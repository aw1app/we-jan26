package com.sl;

import org.springframework.stereotype.Component;

@Component
public class BankAccount {

    private double balance = 0;

    public void deposit(double amount) {
        System.out.println(" In deposit ");
        this.balance = this.balance + amount;
    }

    public void withdraw(double amount) {
        System.out.println(" In withdraw ");
        this.balance = this.balance - amount;
    }

    public double getBalance() {
        System.out.println(" In getBalance ");
        return this.balance;
    }
}
