package com.bnnuyen.springboot.ecommerce.mapper;

import com.bnnuyen.springboot.ecommerce.dto.OrderDTO;
import com.bnnuyen.springboot.ecommerce.entity.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {
    public OrderDTO toOrderDTO(Order order) {
        if (order == null) {
            return null;
        }

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderDTO.setTotalQuantity(order.getTotalQuantity());
        orderDTO.setTotalPrice(order.getTotalPrice());
        orderDTO.setStatus(order.getStatus());
        orderDTO.setDateCreated(order.getDateCreated());
        orderDTO.setLastUpdated(order.getLastUpdated());


        orderDTO.setOrderItems(order.getOrderItems());


        orderDTO.setCustomer(order.getCustomer());
        orderDTO.setAddress(order.getAddress());

        return orderDTO;
    }
}
