package com.sl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("insuranceAcct1")
//@Qualifier("insuranceAcct1")
public class InsuranceAccount implements IAccount{

    private double balance = 0;
    @Autowired @Qualifier("officeAddr") public IAddress addr;

    public IAddress getAddr() {
        return addr;
    }


    public void deposit(double amount) {
        System.out.println("PostOfficeAccount In deposit ");
        this.balance = this.balance + amount;
    }

    public double withdraw(double amount) {
        System.out.println("PostOfficeAccount In withdraw ");
        return this.balance = this.balance - amount;
    }

    public void withdrawOnHolidays(double amount) throws Exception{
        System.out.println(" In withdrawOnHolidays ");
        throw new Exception("Withdrawals on Bank Holiday is not allowed!");
    }

    public double getBalance() {
        System.out.println("PostOfficeAccount In getBalance ");
        return this.balance;
    }
}
