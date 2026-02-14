package com.ik.service.impl;

import com.ik.dto.OrderRequestDto;
import com.ik.dto.OrderResponseDto;
import com.ik.entity.Order;
import com.ik.enums.OrderStatus;
import com.ik.exception.InvalidOrderException;
import com.ik.exception.OrderNotFoundException;
import com.ik.mapper.OrderMapper;
import com.ik.repository.OrderRepository;
import com.ik.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private static long orderIdCounter = 1;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderResponseDto createOrder(OrderRequestDto orderRequest) {
        Long orderId = generateOrderId();
        Order order = OrderMapper.toEntity(orderId, orderRequest);
        orderRepository.save(order);
        return OrderMapper.toDTO(order);
    }

    private Long generateOrderId() {
        return orderIdCounter++;
    }

    @Override
    public OrderResponseDto getOrder(Long orderId) {
        Order order = orderRepository.findByOrderId(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + orderId));
        return OrderMapper.toDTO(order);
    }

    @Override
    public OrderResponseDto updateOrderStatus(Long orderId, OrderStatus orderStatus) {
        Order order = orderRepository.findByOrderId(orderId)
                .orElseThrow(() ->
                        new OrderNotFoundException("Order not found with id: " + orderId));

        if (!order.getOrderStatus().isTransitionValid(orderStatus)) {
            throw new InvalidOrderException("Invalid status change from " + order.getOrderStatus() + " to " + orderStatus);
        }

        order.setOrderStatus(orderStatus);
        orderRepository.save(order);
        return OrderMapper.toDTO(order);
    }

    @Override
    public List<OrderResponseDto> getAllOrders() {
        return orderRepository.getAllOrders()
                .stream()
                .map(OrderMapper::toDTO)
                .collect(Collectors.toList());
    }
}
