package com.ik.service.impl;

import com.ik.dto.OrderRequestDto;
import com.ik.dto.OrderResponseDto;
import com.ik.entity.Order;
import com.ik.enums.OrderStatus;
import com.ik.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderServiceImplTest {

    private OrderRepository orderRepository;

    private OrderServiceImpl orderService;

    @BeforeEach
    void setUp() {
        orderRepository = Mockito.mock(OrderRepository.class);
        orderService = new OrderServiceImpl(orderRepository);
    }

    @Test
    void shouldCreateOrderSuccessfully() {
        OrderRequestDto request = new OrderRequestDto();
        request.setCustomerName("Intkhab");
        request.setAmount(1000.0);
        Order savedOrder = new Order();
        savedOrder.setOrderId(1L);
        savedOrder.setCustomerName("Intkhab");
        savedOrder.setAmount(1000.0);
        savedOrder.setOrderStatus(OrderStatus.NEW);

        when(orderRepository.save(any(Order.class)))
                .thenReturn(savedOrder);
        OrderResponseDto response =
                orderService.createOrder(request);
        assertNotNull(response);
        assertEquals("Intkhab", response.getCustomerName());
        assertEquals(1000.0, response.getAmount());
        assertEquals(OrderStatus.NEW, response.getStatus());
        verify(orderRepository, times(1))
                .save(any(Order.class));
    }
}
