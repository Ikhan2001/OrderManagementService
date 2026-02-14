package com.ik.service;

import com.ik.dto.OrderRequestDto;
import com.ik.dto.OrderResponseDto;
import com.ik.enums.OrderStatus;

import java.util.List;

public interface OrderService {
    OrderResponseDto createOrder(OrderRequestDto orderRequest);
    OrderResponseDto getOrder(Long orderId);
    OrderResponseDto updateOrderStatus(Long orderId, OrderStatus orderStatus);
    List<OrderResponseDto> getAllOrders();
}
