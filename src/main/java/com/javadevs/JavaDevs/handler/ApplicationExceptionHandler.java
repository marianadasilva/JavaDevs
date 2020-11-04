package com.javadevs.JavaDevs.handler;

import com.javadevs.JavaDevs.exception.ExistingEmailException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler (value
            = { ExistingEmailException.class })
    protected ResponseEntity<Object> handleConflict(ExistingEmailException ex, WebRequest request) {
        String bodyOfResponse = "E-mail já se encontra em uso.";
        return handleExceptionInternal(ex, bodyOfResponse,new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
