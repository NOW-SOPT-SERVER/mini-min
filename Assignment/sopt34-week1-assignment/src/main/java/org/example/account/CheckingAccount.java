package org.example.account;

import org.example.exception.ErrorMessage;

import javax.naming.InsufficientResourcesException;
import java.util.Objects;

public class CheckingAccount extends Account {
    public CheckingAccount(String password) { super(password); }

    // 입금
    @Override
    public void deposit(int amount) throws InsufficientResourcesException {
        // 입력 금액 검증 (입금을 위해 입력한 금액이 0원 이상인가?)
        if (amount <= 0) { throw new InsufficientResourcesException(ErrorMessage.INVALID_INPUT_AMOUNT.getMessage()); }
        this.balance += amount;
    }

    // 출금
    @Override
    public void withdraw(int amount, String password) throws InsufficientResourcesException {
        // 계좌 잠금 검증 (패스워드 시도횟수가 5번 미만인가?)
        if (this.tryPassword > 5) {
            throw new InsufficientResourcesException(ErrorMessage.DISABLED_ACCOUNT.getMessage());
        }

        // 비밀번호 검증 (입력한 비밀번호가 계좌의 비밀번호와 같은가?)
        if (!Objects.equals(this.password, password)) {
            plusTryPassword();
            throw new InsufficientResourcesException(ErrorMessage.INVALID_PASSWORD.getMessage());
        }

        // 입력 금액 검증 (출금을 위해 입력한 금액이 0원 이상인가?)
        if (amount <= 0) {
            throw new InsufficientResourcesException(ErrorMessage.INVALID_INPUT_AMOUNT.getMessage());
        }

        // 계좌 잔액 검증 (출금 금액이 계좌 잔액보다 적은 금액인가?)
        if (amount > this.balance) {
            throw new InsufficientResourcesException(ErrorMessage.INSUFFICIENT_BALANCE.getMessage());
        }

        this.balance -= amount;
        this.tryPassword = 0;
    }
}
