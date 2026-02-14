package com.ik.repository;

import com.ik.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class OrderRepository {

    private final Map<Long, Order> orderRepository = new ConcurrentHashMap<>();

    public Order save(Order order){
        orderRepository.put(order.getOrderId(), order);
        return order;
    }

    public Optional<Order> findByOrderId(Long orderId){
        return Optional.ofNullable(orderRepository.get(orderId));
    }

    public List<Order> getAllOrders(){
        List<Order> orderList = orderRepository.entrySet().stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
        return orderList;
    }

}
