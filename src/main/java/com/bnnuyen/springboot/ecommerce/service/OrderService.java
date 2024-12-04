package com.bnnuyen.springboot.ecommerce.service;

import com.bnnuyen.springboot.ecommerce.dao.OrderRepository;
import com.bnnuyen.springboot.ecommerce.dao.ProductRepository;
import com.bnnuyen.springboot.ecommerce.dto.OrderDTO;
import com.bnnuyen.springboot.ecommerce.dto.OrderItemDTO;
import com.bnnuyen.springboot.ecommerce.entity.Order;
import com.bnnuyen.springboot.ecommerce.mapper.OrderMapper;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final ProductRepository productRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public List<OrderDTO> getAllOrders(String email) {
        return orderRepository.findAll().stream().filter(data -> {
                if (email == null || email.isEmpty()) {
                    return true;
                }
                
                return data.getCustomer().getEmail().equals(email);
            })
            .map(OrderMapper::toOrderDTO)
            .map(this::setProductName)
            .collect(Collectors.toList());
    }

    private OrderDTO setProductName(OrderDTO orderDTO) {
        Set<OrderItemDTO> orderItems = orderDTO.getOrderItems();
        if (orderItems != null &&  !orderItems.isEmpty()) {
            Set<OrderItemDTO> orderItemsUpdated = orderItems.stream().map(item -> {
                this.productRepository.findById(item.getProductId())
                    .ifPresent(data -> {
                        item.setProductName(data.getName());
                    });
                return item;
            }).collect(Collectors.toSet());
            orderDTO.setOrderItems(orderItemsUpdated);
            
        }

        return orderDTO;
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
