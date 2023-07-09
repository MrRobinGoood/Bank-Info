package ru.opencode.bankinfo.manuals.exception;

import ru.opencode.bankinfo.exception.NotFoundException;

public class InfoNotFoundException extends NotFoundException {
    public InfoNotFoundException() {
        super("Info not found");
    }
    public InfoNotFoundException(String message) {
        super(message);
    }
}
