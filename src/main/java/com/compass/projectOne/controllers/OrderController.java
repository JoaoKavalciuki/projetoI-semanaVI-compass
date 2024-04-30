package com.compass.projectOne.controllers;

import com.compass.projectOne.entities.Order;
import com.compass.projectOne.entities.User;
import com.compass.projectOne.services.OrderService;
import com.compass.projectOne.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class OrderController {

    private OrderService orderService;
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }
    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        List<Order> users = orderService.findAll();

        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){
        return ResponseEntity.ok(orderService.findById(id));
    }
}
