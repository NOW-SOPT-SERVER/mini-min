package org.example;

import org.example.account.Account;
import org.example.account.AccountService;
import org.example.account.CheckingAccount;
import org.example.account.CheckingAccountService;
import org.example.bank.BankController;

public class Main {
    public static void main(String[] args) {
        CheckingAccount checkingAccount = new CheckingAccount("0000");
        AccountService accountService = new CheckingAccountService(checkingAccount);
        BankController bankOperation = new BankController(accountService);

        bankOperation.start();
    }
}