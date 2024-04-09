package org.example.account;

import org.example.exception.ErrorMessage;

import javax.naming.InsufficientResourcesException;

public class CheckingAccount extends Account {
    public CheckingAccount(int balance) { super(balance); }

    // 입금
    @Override
    public void deposit(int amount) throws InsufficientResourcesException {
        if (amount <= 0) { throw new InsufficientResourcesException(ErrorMessage.INVALID_INPUT_AMOUNT.getMessage()); }
        this.balance += amount;
    }

    // 출금
    @Override
    public void withdraw(int amount) throws InsufficientResourcesException {
        if (amount > balance) { throw new InsufficientResourcesException(ErrorMessage.INSUFFICIENT_BALANCE.getMessage()); }
        if (amount <= 0) { throw new InsufficientResourcesException(ErrorMessage.INVALID_INPUT_AMOUNT.getMessage()); }
        this.balance -= amount;
    }
}
