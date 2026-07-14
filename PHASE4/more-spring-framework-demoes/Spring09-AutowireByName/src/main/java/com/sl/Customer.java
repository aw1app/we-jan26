package com.sl;

public class Customer {
    private String name;
    private BankAccount bankAccount;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public BankAccount getBankAccount() { return bankAccount; }
    public void setBankAccount(BankAccount bankAccount) { this.bankAccount = bankAccount; }
}