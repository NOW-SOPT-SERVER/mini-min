package org.example.exception;

public enum ErrorMessage {
    INSUFFICIENT_BALANCE("[ERROR] 계좌의 잔액이 부족합니다."),
    INVALID_INPUT_AMOUNT("[ERROR] 유효하지 않은 금액을 입력하셨습니다. 다시 입력해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
