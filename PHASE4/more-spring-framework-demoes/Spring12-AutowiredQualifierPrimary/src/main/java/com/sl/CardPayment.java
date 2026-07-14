package com.sl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CardPayment implements PaymentService {
    @Override
    public void processPayment(double amount) {
        System.out.println("[Card] Paid: " + amount);
    }
}