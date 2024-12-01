package com.scalar.sample.service;

import com.scalar.sample.model.twoColumnPrimarykey.Order;
import com.scalar.sample.model.twoColumnPrimarykey.OrderKey;
import com.scalar.sample.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {
    private OrderRepository orderRepository;

    public Order save(Order order){
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public Order getOrderById(OrderKey id ){
        return orderRepository.findById(id).orElse(null);
    }

    public void deleteOrder(OrderKey id){
        orderRepository.deleteById(id);
    }
}
