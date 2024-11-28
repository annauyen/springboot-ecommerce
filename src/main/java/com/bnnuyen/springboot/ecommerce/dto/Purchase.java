package com.bnnuyen.springboot.ecommerce.dto;

import com.bnnuyen.springboot.ecommerce.entity.Address;
import com.bnnuyen.springboot.ecommerce.entity.Customer;
import com.bnnuyen.springboot.ecommerce.entity.Order;
import com.bnnuyen.springboot.ecommerce.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Address address;
    private Order order;
    private Set<OrderItem> orderItems;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}