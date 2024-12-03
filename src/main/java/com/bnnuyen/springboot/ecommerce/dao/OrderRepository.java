package com.bnnuyen.springboot.ecommerce.dao;

import com.bnnuyen.springboot.ecommerce.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;


public interface OrderRepository extends JpaRepository<Order, Long> {
}
