package com.sl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProjectMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Customer cust = context.getBean("customer", Customer.class);
        System.out.println("Customer: " + cust.getName());
        System.out.println("Bank Account Number: " + cust.getBankAccount().getAccountNumber());
        System.out.println("Balance: " + cust.getBankAccount().getBalance());
        context.close();
    }
}