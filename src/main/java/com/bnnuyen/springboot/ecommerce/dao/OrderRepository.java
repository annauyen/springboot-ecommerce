package com.bnnuyen.springboot.ecommerce.dao;

import com.bnnuyen.springboot.ecommerce.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
@RepositoryRestResource(exported = false)
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAll();
}
