package ru.opencode.bankinfo.exception;

public class InvalidParametersException extends RuntimeException {

    public InvalidParametersException() {
        super("Invalid parameter(s)");
    }

    public InvalidParametersException(String message) {
        super(message);
    }
}
