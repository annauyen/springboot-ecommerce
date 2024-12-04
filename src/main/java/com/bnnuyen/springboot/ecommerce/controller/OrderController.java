package com.bnnuyen.springboot.ecommerce.controller;

import com.bnnuyen.springboot.ecommerce.dto.OrderDTO;
import com.bnnuyen.springboot.ecommerce.dto.UpdateStatusRequest;
import com.bnnuyen.springboot.ecommerce.service.OrderService;

import jakarta.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/orders")
@CrossOrigin("*")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderDTO> getAllOrders(@RequestParam(name = "email", required = false) String email) {
        return orderService.getAllOrders(email);
    }

    @GetMapping("/{id}")
    public OrderDTO getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("/{id}/status")
    public void postMethodName(@RequestBody UpdateStatusRequest status, @PathVariable Long id) {
        orderService.updateStatus(id, status.getStatus());
    }
    
}
