package org.example.account;

import javax.naming.InsufficientResourcesException;

public abstract class Account {
    protected int balance;
    protected String password;
    protected int tryPassword = 0;

    public Account(int balance, String password) {
        this.balance = balance;
        this.password = password;
    }

    public int getBalance() {
        return this.balance;
    }

    public void plusTryPassword() {
        this.tryPassword++;
    }

    public abstract void deposit(int amount) throws InsufficientResourcesException;
    public abstract void withdraw(int amount, String password) throws InsufficientResourcesException;
}
