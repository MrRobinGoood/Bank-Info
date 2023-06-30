package ru.opencode.bankinfo.core.exception;

public class InvalidParametersException extends RuntimeException {

    public InvalidParametersException() {
        super("Invalid parameter(s)");
    }

    public InvalidParametersException(String message) {
        super(message);
    }
}
