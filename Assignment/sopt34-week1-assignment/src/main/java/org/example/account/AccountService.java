package org.example.account;

import javax.naming.InsufficientResourcesException;

public interface AccountService {
    void deposit(int amount) throws InsufficientResourcesException;
    void withdraw(int amount, String password) throws InsufficientResourcesException;
    void transfer(int amount, String accountNumber, String password) throws InsufficientResourcesException;
    Account getAccount();
}
