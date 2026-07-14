package com.sl;

import org.springframework.stereotype.Component;

@Component("upi")
public class UpiPayment implements PaymentService {
    @Override
    public void processPayment(double amount) {
        System.out.println("[UPI] Paid: " + amount);
    }
}