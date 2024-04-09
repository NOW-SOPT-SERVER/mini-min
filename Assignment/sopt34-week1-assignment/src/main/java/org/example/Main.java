package org.example;

import org.example.account.Account;
import org.example.account.AccountService;
import org.example.account.CheckingAccount;
import org.example.account.CheckingAccountService;
import org.example.controller.BankController;
import org.example.exceptions.InsufficientFundsException;

public class Main {
    public static void main(String[] args) throws InsufficientFundsException {
        Account account = new CheckingAccount(1000); // 초기 잔액 설정
        AccountService accountService = new CheckingAccountService(account);
        BankController bankOperation = new BankController(accountService);

        bankOperation.start();
    }
}