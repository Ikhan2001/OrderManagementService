package com.ik.dto;

import com.ik.enums.OrderStatus;

public class OrderResponseDto {

    private Long orderId;
    private String customerName;
    private Double amount;
    private OrderStatus status;

    public OrderResponseDto() {
    }

    public OrderResponseDto(Long orderId, String customerName, Double amount, OrderStatus status) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.amount = amount;
        this.status = status;
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Double getAmount() {
        return amount;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
