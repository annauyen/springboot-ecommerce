package com.bnnuyen.springboot.ecommerce.service;

import com.bnnuyen.springboot.ecommerce.dto.Purchase;
import com.bnnuyen.springboot.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
//    List<Purchase> getAllPurchase();
}
