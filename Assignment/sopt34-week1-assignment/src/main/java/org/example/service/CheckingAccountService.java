package org.example.service;

import org.example.domain.Account;
import org.example.domain.CheckingAccount;
import org.example.service.AccountService;

import javax.naming.InsufficientResourcesException;

public class CheckingAccountService implements AccountService {
    private final CheckingAccount account;

    public CheckingAccountService(CheckingAccount account) {
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
    public void transfer(int amount, String accountNumber, String password) throws InsufficientResourcesException {
        account.transfer(amount, accountNumber, password);
        System.out.println(accountNumber + "계좌로 " + amount + "원을 송금했습니다.");
    }

    @Override
    public Account getAccount() {
        return this.account;
    }
}
