package com.matheushdas.javabank.exception.handler;

import com.matheushdas.javabank.exception.DeleteWalletException;
import com.matheushdas.javabank.exception.JavaBankException;
import com.matheushdas.javabank.exception.WalletDataAlreadyExistsException;
import com.matheushdas.javabank.exception.dto.InvalidParamsDTO;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<InvalidParamsDTO> invalidParams = ex.getFieldErrors().stream()
                .map(fe -> new InvalidParamsDTO(fe.getField(), fe.getDefaultMessage()))
                .toList();

        ProblemDetail pb = ProblemDetail.forStatus(400);

        pb.setTitle("Invalid request parameters");
        pb.setDetail("There is invalid fields on the request");
        pb.setProperty("invalid-params", invalidParams);

        return pb;
    }

    @ExceptionHandler(DeleteWalletException.class)
    public ProblemDetail handleDeleteWalletException(DeleteWalletException ex) {
        return ex.toProblemDetail();
    }
}
