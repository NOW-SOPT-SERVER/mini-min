package org.example.account;

import javax.naming.InsufficientResourcesException;

public class CheckingAccountService implements AccountService {
    private final Account account;

    public CheckingAccountService(Account account) {
        this.account = account;
    }

    @Override
    public void deposit(int amount) throws InsufficientResourcesException {
        account.deposit(amount);
        System.out.println(amount + "원이 입금되었습니다.");
    }

    @Override
    public void withdraw(int amount, String password) throws InsufficientResourcesException {
        account.withdraw(amount, password);
        System.out.println(amount + "원이 출금되었습니다.");
    }

    @Override
    public Account getAccount() {
        return this.account;
    }
}
