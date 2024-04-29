package com.np.coffeeorderservice.controller;

import com.np.coffeeorderservice.model.Order;
import com.np.coffeeorderservice.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findOrderById(@PathVariable Long id) {
        logger.debug("Received request to find order by ID: {}", id);
        Order order = orderService.findOrderById(id);
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Order saveOrder(@RequestBody Order order) {
        logger.debug("Received request to save order: {}", order);
        return orderService.saveOrder(order);
    }

    @GetMapping
    public List<Order> findAllOrders() {
        logger.debug("Received request to find all orders");
        return orderService.findAllOrders();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order order) {
        logger.debug("Received request to update order with ID {}: {}", id, order);
        Order updatedOrder = orderService.updateOrder(order);
        if (updatedOrder != null) {
            return ResponseEntity.ok(updatedOrder);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        logger.debug("Received request to delete order with ID: {}", id);
        orderService.deleteOrder(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllOrders() {
        logger.debug("Received request to delete all orders");
        orderService.deleteAllOrders();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/date/{startDate}/{endDate}")
    public List<Order> findOrdersByOrderDateBetween(@PathVariable LocalDateTime startDate, @PathVariable LocalDateTime endDate) {
        logger.debug("Received request to find orders between dates: {} and {}", startDate, endDate);
        return orderService.findOrdersByOrderDateBetween(startDate, endDate);
    }
}
