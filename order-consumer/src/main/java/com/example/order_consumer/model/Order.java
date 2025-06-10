package com.example.order_consumer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Deprecated
@Data
@NoArgsConstructor
@AllArgsConstructor
/*
 * NOTE: Not used, refer to order model in the producer module for explanation
 */
public class Order {
    private String id;
    private String product;
    private int quantity;
    private double price;
}