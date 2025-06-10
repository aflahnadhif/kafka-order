package com.example.kafka_streams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafkaStreams;

@SpringBootApplication
/*
 * NOTE: @EnableKafkaStreams Annotation is a must
 * This loads all necessary beans for KafkaStream to work, such
 * as to inject the dependencies
 */
@EnableKafkaStreams
public class KafkaStreamsApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaStreamsApplication.class, args);
	}

}
