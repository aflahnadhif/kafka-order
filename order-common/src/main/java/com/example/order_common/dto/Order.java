package com.example.order_common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private String id;
    private String product;
    private int quantity;
    private double price;
    private Timestamp timestamp;
}
