package com.javadevs.JavaDevs.handler;

import com.javadevs.JavaDevs.exception.*;
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

    @ExceptionHandler (value
            = { ExpiredTokenException.class })
    protected ResponseEntity<Object> handleConflict(ExpiredTokenException ex, WebRequest request) {
        String bodyOfResponse = "Token expirado.";
        return handleExceptionInternal(ex, bodyOfResponse,new HttpHeaders(), HttpStatus.UNAUTHORIZED, request);
    }

    @ExceptionHandler (value
            = { InvalidLoginException.class })
    protected ResponseEntity<Object> handleConflict(InvalidLoginException ex, WebRequest request) {
        String bodyOfResponse = "E-mail/Senha informados inválidos!";
        return handleExceptionInternal(ex, bodyOfResponse,new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler (value
            = { InvalidEmailUserException.class })
    protected ResponseEntity<Object> handleConflict(InvalidEmailUserException ex, WebRequest request) {
        String bodyOfResponse = "Usuário informado não encontrado.";
        return handleExceptionInternal(ex, bodyOfResponse,new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler (value
            = { AppointmentNotExists.class })
    protected ResponseEntity<Object> handleConflict(AppointmentNotExists ex, WebRequest request) {
        String bodyOfResponse = "Nenhum compromisso encontrado";
        return handleExceptionInternal(ex, bodyOfResponse,new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler (value
            = { ActorInvalidRequest.class })
    protected ResponseEntity<Object> handleConflict(ActorInvalidRequest ex, WebRequest request) {
        String bodyOfResponse = "Ator(a) com parâmetros inválidos, não existente ou não definido, por favor, verifique as informações!";
        return handleExceptionInternal(ex, bodyOfResponse,new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

}
