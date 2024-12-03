package com.bnnuyen.springboot.ecommerce.service;

import com.bnnuyen.springboot.ecommerce.dao.OrderRepository;
import com.bnnuyen.springboot.ecommerce.dto.OrderDTO;
import com.bnnuyen.springboot.ecommerce.entity.Order;
import com.bnnuyen.springboot.ecommerce.mapper.OrderMapper;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(OrderMapper::toOrderDTO)
                .collect(Collectors.toList());
    }

    public OrderDTO getOrderById(Long id) {
        return orderRepository.findById(id).map(OrderMapper::toOrderDTO)
            .orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404)));
    }

    @Transactional
    public void updateStatus(Long id, String status) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            order.setStatus(status);
        } else {
            throw new ResponseStatusException(HttpStatusCode.valueOf(404));
        }
    }
}
