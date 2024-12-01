package com.scalar.sample.controller;

import com.scalar.sample.model.twoColumnPrimarykey.Order;
import com.scalar.sample.model.twoColumnPrimarykey.OrderKey;
import com.scalar.sample.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderService orderService;

    @PostMapping
    public Order create(@RequestBody Order order){
        return orderService.save(order);
    }

    @GetMapping
    public List<Order> getAllOrder(){
        return orderService.getAllOrders();
    }

    @GetMapping("/{orderId}/{productId}")
    public Order getOrderById(@PathVariable("orderId") Long orderId,
                              @PathVariable("productId") Long productId){
        return orderService.getOrderById(new OrderKey(orderId, productId));
    }

    @DeleteMapping("/{orderId}/{productId}")
    public void deleteOrder(@PathVariable("orderId") Long orderId,
                            @PathVariable("productId") Long productId){
        orderService.deleteOrder(new OrderKey(orderId, productId));
    }
}
