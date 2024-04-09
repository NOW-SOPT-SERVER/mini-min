package org.example.account;

import javax.naming.InsufficientResourcesException;

public abstract class Account {
    protected int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return this.balance;
    }

    public abstract void deposit(int amount) throws InsufficientResourcesException;
    public abstract void withdraw(int amount) throws InsufficientResourcesException;
}
