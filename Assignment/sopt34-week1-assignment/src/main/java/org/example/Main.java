package org.example;

import org.example.service.AccountService;
import org.example.domain.CheckingAccount;
import org.example.service.CheckingAccountService;
import org.example.controller.BankController;

public class Main {
    public static void main(String[] args) {
        CheckingAccount checkingAccount = new CheckingAccount("0000");
        AccountService accountService = new CheckingAccountService(checkingAccount);
        BankController bankOperation = new BankController(accountService);

        bankOperation.start();
    }
}