package org.example.account;

import javax.naming.InsufficientResourcesException;

public class CheckingAccount extends Account {
    public CheckingAccount(int balance) { super(balance); }

    // 입금
    @Override
    public void deposit(int amount) {
        this.balance = amount;
    }

    // 출금
    @Override
    public void withdraw(int amount) throws InsufficientResourcesException {
        if (amount > balance) { throw new InsufficientResourcesException("계좌의 출금 잔액이 부족합니다."); }
        this.balance -= amount;
    }
}
