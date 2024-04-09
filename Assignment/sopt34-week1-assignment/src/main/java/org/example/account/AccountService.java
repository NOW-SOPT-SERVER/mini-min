package org.example.account;

import javax.naming.InsufficientResourcesException;

public interface AccountService {
    void deposit(int amount) throws InsufficientResourcesException;
    void withdraw(int amount) throws InsufficientResourcesException;
    Account getAccount();
}
