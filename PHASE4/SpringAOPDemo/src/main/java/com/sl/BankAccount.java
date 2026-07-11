package com.sl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("bankAcct1")
//@Qualifier("bankAcct1")
//@Scope("singleton")
public class BankAccount implements IAccount{

    private double balance = 0;

    @Autowired @Qualifier("officeAddr") public IAddress addr;

    public IAddress getAddr() {
        return addr;
    }

    public void deposit(double amount) {
        System.out.println(" In deposit ");
        this.balance = this.balance + amount;
    }

    public double withdraw(double amount) {
        System.out.println(" In withdraw ");
        this.balance = this.balance - amount;
        return this.balance;
    }

    public void withdrawOnHolidays(double amount) throws Exception{
        System.out.println(" In withdrawOnHolidays ");
        throw new Exception("Withdrawals on Bank Holiday is not allowed!");
    }

    public double getBalance() {
        System.out.println(" In getBalance ");
        return this.balance;
    }
}
