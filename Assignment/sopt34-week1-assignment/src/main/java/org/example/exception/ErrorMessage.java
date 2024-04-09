package org.example.exception;

public enum ErrorMessage {
    INSUFFICIENT_BALANCE("계좌의 잔액이 부족합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
