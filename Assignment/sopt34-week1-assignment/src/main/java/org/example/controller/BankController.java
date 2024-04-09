package org.example.controller;

import org.example.account.AccountService;

import javax.naming.InsufficientResourcesException;
import java.util.Scanner;

public class BankController {
    private final AccountService accountService;
    private final Scanner scanner;

    public BankController(AccountService accountService) {
        this.accountService = accountService;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\n===== 안녕하세요 민재은행입니다. 어떤 업무를 도와드릴까요? =====");
            System.out.println("1. 입금하기");
            System.out.println("2. 출금하기");
            System.out.println("3. 잔액 확인하기");
            System.out.println("4. 종료하기");
            System.out.print("원하는 작업의 번호를 입력해주세요: ");

            String action = scanner.nextLine();

            switch (action) {
                case "1":
                    deposit();
                    break;
                case "2":
                    withdraw();
                    break;
                case "3":
                    displayBalance();
                    break;
                case "4":
                    System.exit(0);
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                    break;
            }
        }
    }

    private void deposit() {
        System.out.print("입금할 금액을 입력해주세요: ");
        int amount = Integer.parseInt(scanner.nextLine());
        try {
            accountService.deposit(amount);
        } catch (InsufficientResourcesException error) {
            System.out.println(error.getMessage());
        }
        displayBalance();
    }

    private void withdraw() {
        System.out.print("출금할 금액을 입력해주세요: ");
        int amount = Integer.parseInt(scanner.nextLine());

        System.out.print("계좌 비밀번호 네자리를 입력해주세요: ");
        String password = scanner.nextLine();

        try {
            accountService.withdraw(amount, password);
        } catch (InsufficientResourcesException error) {
            System.out.println(error.getMessage());
        }
        displayBalance();
    }

    private void displayBalance() {
        System.out.println("현재 잔액은 " + accountService.getAccount().getBalance() + "원입니다.");
    }
}
