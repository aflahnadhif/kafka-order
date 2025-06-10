package com.example.order_producer.controller;

import com.example.order_common.dto.Order;
import com.example.order_producer.service.KafkaProducerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.Instant;

@RestController
public class OrderController {
    public final KafkaProducerService kafkaProducerService;

    public OrderController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping("orders")
    public String createOrder(@RequestBody Order order) {
        // Can be changed to be obtained from request
        order.setTimestamp(Timestamp.from(Instant.now()));

        this.kafkaProducerService.sendOrder(order);

        return "Order created: " + order;
    }
}
