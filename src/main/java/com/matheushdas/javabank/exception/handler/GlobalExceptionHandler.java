package com.matheushdas.javabank.exception.handler;

import com.matheushdas.javabank.exception.JavaBankException;
import com.matheushdas.javabank.exception.WalletDataAlreadyExistsException;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(JavaBankException.class)
    public ProblemDetail handleJavaBankException(JavaBankException ex) {
        return ex.toProblemDetail();
    }

    @ExceptionHandler(WalletDataAlreadyExistsException.class)
    public ProblemDetail handleWalletDataAlreadyExistsException(WalletDataAlreadyExistsException ex) {
        return ex.toProblemDetail();
    }
}
