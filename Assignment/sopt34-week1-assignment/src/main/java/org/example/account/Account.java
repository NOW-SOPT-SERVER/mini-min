package org.example.account;

import javax.naming.InsufficientResourcesException;
import java.util.Random;

public abstract class Account {
    private final String accountNumber;
    protected int balance;
    protected String password;
    protected int tryPassword = 0;

    public Account(String password) {
        this.password = password;
        accountNumber = generateAccountNumber();
        this.balance = 0;
    }

    // 계좌번호 생성 메서드 : Random 클래스를 활용해서 열자리 String 계좌번호를 랜덤으로 생성하도록 함
    private String generateAccountNumber() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int num = random.nextInt(10);
            stringBuilder.append(num);
        }
        return stringBuilder.toString();
    }

    // Getter
    public String getAccountNumber() { return this.accountNumber; }
    public int getBalance() { return this.balance; }

    public void plusTryPassword() {
        this.tryPassword++;
    }

    public abstract void deposit(int amount) throws InsufficientResourcesException;
    public abstract void withdraw(int amount, String password) throws InsufficientResourcesException;
}
