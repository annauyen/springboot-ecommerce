package com.bnnuyen.springboot.ecommerce.service;

import com.bnnuyen.springboot.ecommerce.dao.CustomerRepository;
import com.bnnuyen.springboot.ecommerce.dto.Purchase;
import com.bnnuyen.springboot.ecommerce.dto.PurchaseResponse;
import com.bnnuyen.springboot.ecommerce.entity.Customer;
import com.bnnuyen.springboot.ecommerce.entity.Order;
import com.bnnuyen.springboot.ecommerce.entity.OrderItem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;

    }
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        // retrieve the order info from dto
        Order order = purchase.getOrder();

        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        // populate order with orderItems
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));

        // populate order with billingAddress and shippingAddress
        order.setAddress(purchase.getAddress());

        // populate customer with order
        Customer customer = purchase.getCustomer();
        customer.add(order);

        // save to the database
        customerRepository.save(customer);

        // return a response
        return new PurchaseResponse(orderTrackingNumber);
    }

//    @Override
//    public List<Purchase> getAllPurchase() {
//        String jpql = "SELECT o FROM Order o";
//        TypedQuery<Purchase> query = entityManager.createQuery(jpql, Purchase.class);
//        return query.getResultList();
//    }


    private String generateOrderTrackingNumber() {

        // generate a random UUID number (UUID version-4)
        // For details see: https://en.wikipedia.org/wiki/Universally_unique_identifier
        //
        return UUID.randomUUID().toString();
    }
}
