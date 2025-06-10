package com.example.kafka_streams.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
/*
 * NOTE: Consumer listener made for testing
 */
public class HourlyTransactionConsumer {
    @KafkaListener(topics = "hourly-transaction-topic")
    public void consume(@Payload Double value) {
        System.out.println("==============================");
        System.out.println("doubleValue: " + value);
        System.out.println("==============================");
    }
}
