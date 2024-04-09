package org.example;

import org.example.account.Account;
import org.example.account.AccountService;
import org.example.account.CheckingAccount;
import org.example.account.CheckingAccountService;
import org.example.controller.BankController;

public class Main {
    public static void main(String[] args) {
        Account account = new CheckingAccount(1000, "0000"); // 초기 잔액 설정
        AccountService accountService = new CheckingAccountService(account);
        BankController bankOperation = new BankController(accountService);

        bankOperation.start();
    }
}