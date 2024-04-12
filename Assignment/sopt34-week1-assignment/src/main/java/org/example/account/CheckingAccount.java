package org.example.account;

import org.example.exception.ErrorMessage;

import javax.naming.InsufficientResourcesException;
import java.util.Objects;

public class CheckingAccount extends Account {
    private final static int GROUND_AMOUNT = 0
    private final static int MAX_TRY_PASSWORD_ATTEMPTS = 5;
    private final static int ACCOUNT_NUMBER_LENGTH = 10;

    public CheckingAccount(String password) { super(password); }

    // 입금
    @Override
    public void deposit(int amount) throws InsufficientResourcesException {
        validateInputAmount(amount);
        this.balance += amount;
    }

    // 출금
    @Override
    public void withdraw(int amount, String password) throws InsufficientResourcesException {
        validateAbleAccount();          // 계좌 잠금 검증
        validatePassword(password);     // 비밀번호 검증
        validateInputAmount(amount);    // 입력 금액 검증
        validateBalance(amount);        // 계좌 잔액 검증

        this.balance -= amount;
        this.tryPassword = GROUND_AMOUNT;
    }

    // 송금 (송금은 입출금 계좌에만 가능하므로, 상위 클래스인 Account에 정의하지 않음)
    public void transfer(int amount, String accountNumber, String password) throws InsufficientResourcesException {
        validateAccountNumber(accountNumber);    // 송금 계좌 검증
        validateAbleAccount();                   // 계좌 잠금 검증
        validatePassword(password);              // 비밀번호 검증
        validateInputAmount(amount);             // 송금 금액 검증
        validateBalance(amount);                 // 계좌 잔액 검증

        this.balance -= amount;
    }

    // 계좌 잠금 검증 (패스워드 시도횟수가 5번 미만인가?)
    private void validateAbleAccount() throws InsufficientResourcesException {
        if (this.tryPassword > MAX_TRY_PASSWORD_ATTEMPTS) {
            throw new InsufficientResourcesException(ErrorMessage.DISABLED_ACCOUNT.getMessage());
        }
    }

    // 비밀번호 검증 (입력한 비밀번호가 계좌의 비밀번호와 같은가?)
    private void validatePassword(String password) throws InsufficientResourcesException {
        if (!Objects.equals(this.password, password)) {
            plusTryPassword();
            throw new InsufficientResourcesException(ErrorMessage.INVALID_PASSWORD.getMessage());
        }
    }

    // 입력 금액 검증 (은행 작업을 위해 입력한 금액이 0원 이상인가?)
    private void validateInputAmount(int amount) throws InsufficientResourcesException {
        if (amount <= GROUND_AMOUNT) {
            throw new InsufficientResourcesException(ErrorMessage.INVALID_INPUT_AMOUNT.getMessage());
        }
    }

    // 계좌 잔액 검증 (작업 금액이 계좌 잔액보다 적은 금액인가?)
    private void validateBalance(int amount) throws InsufficientResourcesException {
        if (amount > this.balance) {
            throw new InsufficientResourcesException(ErrorMessage.INSUFFICIENT_BALANCE.getMessage());
        }
    }

    // 계좌 검증 (입력한 계좌번호가 유효한 계좌번호인가?)
    private void validateAccountNumber(String accountNumber) throws InsufficientResourcesException {
        if (accountNumber.length() != ACCOUNT_NUMBER_LENGTH) {
            throw new InsufficientResourcesException(ErrorMessage.INVALID_ACCOUNT.getMessage());
        }
    }
}
