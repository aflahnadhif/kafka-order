package com.example.order_producer.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Deprecated
/*
 * NOTE: Will not be used
 * When we use a model in the KafkaTemplate parameter, the model
 * will be used again for deserialization in the consumer side. Best practice
 * is to use the same model for both serialization and deserialization. Hence,
 * new model is made in the order-common module to be used by both parties.
 * Aflah Nadhif Hammam
 */
public class Order implements Serializable {
    private String orderId;
    private String customerId;
    private BigDecimal totalAmount;
    private LocalDateTime orderDate;
    private String status;

    // Default constructor
    public Order() {
    }

    // Parameterized constructor
    public Order(String orderId, String customerId, BigDecimal totalAmount, LocalDateTime orderDate, String status) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
        this.status = status;
    }

    // Getters and Setters
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", totalAmount=" + totalAmount +
                ", orderDate=" + orderDate +
                ", status='" + status + '\'' +
                '}';
    }
}