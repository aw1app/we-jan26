package com.sl;

public interface IAccount {

    public void deposit(double amount);
    public void withdraw(double amount);
    public double getBalance();

    public IAddress getAddr();
}
