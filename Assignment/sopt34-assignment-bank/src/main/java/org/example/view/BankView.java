package org.example.view;

import java.util.Scanner;

public class BankView {
    private final Scanner scanner = new Scanner(System.in);

    // 처음 은행 프로그램 작동 시 유저에게 어떤 업무를 선택할지 표츌하는 메서드
    public String getBankOption() {
        System.out.println("\n===== 안녕하세요 민재은행입니다. 어떤 업무를 도와드릴까요? =====");
        System.out.println("1. 입금하기");
        System.out.println("2. 출금하기");
        System.out.println("3. 송금하기");
        System.out.println("4. 잔액 확인하기");
        System.out.println("5. 종료하기");
        System.out.print("원하는 작업의 번호를 입력해주세요: ");
        return scanner.nextLine();
    }

    // 유저로부터 예금 금액을 입력받는 메서드
    public int getDepositAmount() {
        System.out.print("입금할 금액을 입력해주세요: ");
        return Integer.parseInt(scanner.nextLine());
    }

    // 유저로부터 출금 금액을 입력받는 메서드
    public int getWithdrawAmount() {
        System.out.print("출금할 금액을 입력해주세요: ");
        return Integer.parseInt(scanner.nextLine());
    }

    // 유저로부터 비밀번호를 입력받는 메서드
    public String getPassword() {
        System.out.print("계좌 비밀번호 네자리를 입력해주세요: ");
        return scanner.nextLine();
    }

    // 유저로부터 계좌번호를 입력받는 메서드
    public String getAccountNumber() {
        System.out.print("송금할 계좌번호 열자리를 입력해주세요: ");
        return scanner.nextLine();
    }
}
