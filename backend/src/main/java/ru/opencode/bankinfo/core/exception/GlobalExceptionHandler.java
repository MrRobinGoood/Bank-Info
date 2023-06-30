package ru.opencode.bankinfo.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.opencode.bankinfo.manuals.exception.InfoNotFoundException;
import ru.opencode.bankinfo.manuals.exception.ManualNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleBuildingNotFoundException(NotFoundException e) {
        return new ResponseEntity<>(new AppError(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidParametersException.class)
    public ResponseEntity<?> handleBuildingInvalidParametersException(InvalidParametersException e) {
        return new ResponseEntity<>(new AppError(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InfoNotFoundException.class)
    public ResponseEntity<?> handleBuildingNotFoundException(InfoNotFoundException e) {
        return new ResponseEntity<>(new AppError(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ManualNotFoundException.class)
    public ResponseEntity<?> handleBuildingNotFoundException(ManualNotFoundException e) {
        return new ResponseEntity<>(new AppError(e.getMessage()), HttpStatus.NOT_FOUND);
    }

       @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return new ResponseEntity<>(new AppError(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return new ResponseEntity<>(new AppError(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
