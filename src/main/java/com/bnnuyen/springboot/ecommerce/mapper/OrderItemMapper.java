package com.bnnuyen.springboot.ecommerce.mapper;

import org.springframework.stereotype.Component;

import com.bnnuyen.springboot.ecommerce.dao.ProductRepository;
import com.bnnuyen.springboot.ecommerce.dto.OrderItemDTO;
import com.bnnuyen.springboot.ecommerce.entity.OrderItem;

public class OrderItemMapper {
    public static OrderItemDTO toOrderItemDTO(OrderItem orderItem) {
        if (orderItem == null) {
            return null;
        }

        OrderItemDTO orderItemDTO = new OrderItemDTO();
        orderItemDTO.setId(orderItem.getId());
        orderItemDTO.setImageUrl(orderItem.getImageUrl());
        orderItemDTO.setProductId(orderItem.getProductId());
        orderItemDTO.setQuantity(orderItem.getQuantity());
        orderItemDTO.setUnitPrice(orderItem.getUnitPrice());
        

        return orderItemDTO;
    }
}
