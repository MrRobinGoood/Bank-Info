package ru.opencode.bankinfo.core.exception;

public class AppError {
    String message;

    public AppError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}