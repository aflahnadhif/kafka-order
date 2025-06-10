package com.example.kafka_streams.stream;

import com.example.order_common.dto.Order;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Configuration
public class TransactionPerHourCalcStream {

    /*
     * NOTE: Bean is made for KafkaStream to automatically work
     * Bean name is customized as there are already a bean with the same name?
     * 2nd param need to be evaluated, as it is not clear what is the usage of the SerdesConfig and OrderSerdes class
     */
    @Bean(name = "transactionPerHourCalcNew")
    public KStream<String, Order> kStream(StreamsBuilder streamsBuilder, Serde<Order> orderSerde) {
        System.out.println("start stream");

        KStream<String, Order> stream = streamsBuilder.stream("orders-topic", Consumed.with(Serdes.String(), orderSerde));

        stream
            // Group by per hour
            .groupBy((key, order) -> order.getTimestamp().toInstant().truncatedTo(ChronoUnit.HOURS).toString())
            // Can be changed to hour, 1 minute is only used for testing
            .windowedBy(TimeWindows.ofSizeWithNoGrace(Duration.ofMinutes(1)))
            .aggregate(
                () -> 0.0,
                (key, order, total) -> total + order.getQuantity(),
                Materialized.with(Serdes.String(), Serdes.Double())
            )
            .toStream()
            // Window size used not is for 1 minute, change to 1 hour later
            .to("hourly-transaction-topic", Produced.with(WindowedSerdes.timeWindowedSerdeFrom(String.class, 60000), Serdes.Double()));

        return stream;
    }
}
