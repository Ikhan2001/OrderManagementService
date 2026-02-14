package com.ik.entity;

import com.ik.enums.OrderStatus;


public class Order {
    private Long orderId;
    private String customerName;
    private Double amount;
    private OrderStatus orderStatus;

    public Order() {
    }

    public Order(Long orderId, String customerName, Double amount, OrderStatus orderStatus) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.amount = amount;
        this.orderStatus = orderStatus;
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

    public OrderStatus getOrderStatus() {
        return orderStatus;
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

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

}
