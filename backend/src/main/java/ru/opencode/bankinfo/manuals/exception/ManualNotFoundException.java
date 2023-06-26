package ru.opencode.bankinfo.manuals.exception;

import ru.opencode.bankinfo.core.exception.NotFoundException;

public class ManualNotFoundException extends NotFoundException {

    public ManualNotFoundException() {
        super("Manual not found");
    }

    public ManualNotFoundException(String message) {
        super(message);
    }
}
