package com.sl;

public interface IAccount {

    public void deposit(double amount);
    public double withdraw(double amount);
    public double getBalance();

    public void withdrawOnHolidays(double amount) throws Exception;

    public IAddress getAddr();
}
