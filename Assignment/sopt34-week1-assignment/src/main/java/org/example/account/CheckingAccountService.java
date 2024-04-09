package org.example.account;

import javax.naming.InsufficientResourcesException;

public class CheckingAccountService implements AccountService {
    private final Account account;

    public CheckingAccountService(Account account) {
        this.account = account;
    }

    @Override
    public void deposit(int amount) {
        account.deposit(amount);
        System.out.println("Deposited: " + amount);
    }

    @Override
    public void withdraw(int amount) throws InsufficientResourcesException {
        account.withdraw(amount);
        System.out.println("Withdrew: " + amount);
    }

    @Override
    public Account getAccount() {
        return this.account;
    }
}
