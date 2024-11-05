package com.matheushdas.javabank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public abstract class JavaBankException extends RuntimeException {
    public JavaBankException(String message) {
        super(message);
    }

    public ProblemDetail toProblemDetail() {
        ProblemDetail pb = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        pb.setTitle("JavaBank Internal Server Error");
        pb.setDetail("Contact Support");

        return pb;
    }
}
