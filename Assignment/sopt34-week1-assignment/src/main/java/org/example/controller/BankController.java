package org.example.controller;

import org.example.service.AccountService;
import org.example.view.BankView;

import javax.naming.InsufficientResourcesException;

public class BankController {
    private final AccountService accountService;
    private final BankView bankView;

    public BankController(AccountService accountService) {
        this.accountService = accountService;
        this.bankView = new BankView();
    }

    public void start() {
        while (true) {
            String action = bankView.getBankOption();
            switch (action) {
                case "1" -> depositAction();
                case "2" ->  withdrawAction();
                case "3" -> transferAction();
                case "4" -> displayBalance();
                case "5" -> System.exit(0);
                default -> System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }

    private void depositAction() {
        int amount = bankView.getDepositAmount();
        try {
            accountService.deposit(amount);
        } catch (InsufficientResourcesException error) {
            System.out.println(error.getMessage());
        }
        displayBalance();
    }

    private void withdrawAction() {
        int amount = bankView.getWithdrawAmount();
        String password = bankView.getPassword();
        try {
            accountService.withdraw(amount, password);
        } catch (InsufficientResourcesException error) {
            System.out.println(error.getMessage());
        }
        displayBalance();
    }

    private void transferAction() {
        String accountNumber = bankView.getAccountNumber();
        int amount = bankView.getWithdrawAmount();
        String password = bankView.getPassword();

        try {
            accountService.transfer(amount, accountNumber, password);
        } catch (InsufficientResourcesException error) {
            System.out.println(error.getMessage());
        }
        displayBalance();
    }

    private void displayBalance() {
        System.out.println("현재 잔액은 " + accountService.getAccount().getBalance() + "원입니다.");
    }
}
