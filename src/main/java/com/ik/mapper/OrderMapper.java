package com.ik.mapper;

import com.ik.dto.OrderRequestDto;
import com.ik.dto.OrderResponseDto;
import com.ik.entity.Order;
import com.ik.enums.OrderStatus;
import lombok.Builder;

public class OrderMapper {

    public static Order toEntity(Long id, OrderRequestDto dto) {
        Order order = new Order();
        order.setOrderId(id);
        order.setCustomerName(dto.getCustomerName());
        order.setAmount(dto.getAmount());
        order.setOrderStatus(OrderStatus.NEW);
        return order;
    }

    public static OrderResponseDto toDTO(Order order) {
        OrderResponseDto dto = new OrderResponseDto();
        dto.setOrderId(order.getOrderId());
        dto.setCustomerName(order.getCustomerName());
        dto.setAmount(order.getAmount());
        dto.setStatus(order.getOrderStatus());
        return dto;
    }
}
