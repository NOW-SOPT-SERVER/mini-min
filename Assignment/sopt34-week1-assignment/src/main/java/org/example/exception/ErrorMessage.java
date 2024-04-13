package org.example.exception;

public enum ErrorMessage {
    INSUFFICIENT_BALANCE("[ERROR] 출금할 계좌의 잔액이 부족합니다."),
    INVALID_INPUT_AMOUNT("[ERROR] 유효하지 않은 금액을 입력하셨습니다. 다시 입력해주세요."),
    INVALID_PASSWORD("[ERROR] 잘못된 비밀번호입니다. 다시 입력해주세요."),
    DISABLED_ACCOUNT("[ERROR] 비밀번호 시도 횟수 초과로 계좌가 잠겼습니다. 은행에 방문해주세요."),
    INVALID_ACCOUNT("[ERROR] 유효하지 않은 계좌번호입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
