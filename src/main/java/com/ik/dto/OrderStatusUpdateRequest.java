package com.ik.dto;

import com.ik.enums.OrderStatus;

public class OrderStatusUpdateRequest {
    private OrderStatus status;

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
