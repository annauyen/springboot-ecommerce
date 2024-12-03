package com.bnnuyen.springboot.ecommerce.mapper;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.bnnuyen.springboot.ecommerce.dto.AddressDTO;
import com.bnnuyen.springboot.ecommerce.dto.CustomerDTO;
import com.bnnuyen.springboot.ecommerce.dto.OrderDTO;
import com.bnnuyen.springboot.ecommerce.dto.OrderItemDTO;
import com.bnnuyen.springboot.ecommerce.entity.Order;

public class OrderMapper {
    public static OrderDTO toOrderDTO(Order order) {
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

        Set<OrderItemDTO> orderItemDTOs = order.getOrderItems().stream().map(OrderItemMapper::toOrderItemDTO).collect(Collectors.toSet());
        orderDTO.setOrderItems(orderItemDTOs);

        CustomerDTO customer = new CustomerDTO();
        customer.setFullName(order.getCustomer().getFullName());
        customer.setEmail(order.getCustomer().getEmail());
        customer.setId(order.getCustomer().getId());

        orderDTO.setCustomer(customer);

        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setAddress(order.getAddress().getAddress());
        orderDTO.setAddress(addressDTO);

        return orderDTO;
    }
}
