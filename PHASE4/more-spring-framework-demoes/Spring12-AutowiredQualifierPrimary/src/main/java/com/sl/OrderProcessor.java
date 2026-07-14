package com.sl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderProcessor {
    @Autowired
    private PaymentService defaultPayment;

    @Autowired
    @Qualifier("upi")
    private PaymentService upiPayment;

    public void processOrder(double amount) {
        defaultPayment.processPayment(amount);
        upiPayment.processPayment(amount);
    }
}