package com.example.challengeBackend.exceptions;

import com.example.challengeBackend.models.response.GenericResponse;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { RegistrationException.class, LoginException.class })
    protected ResponseEntity<GenericResponse> handleRegistrationException (Exception ex, WebRequest request) {
        return ResponseEntity.internalServerError().body(new GenericResponse(ex.getMessage()));
    }

    @ExceptionHandler(value = { ConstraintViolationException.class })
    protected ResponseEntity<GenericResponse> handleRegistrationException (ConstraintViolationException ex, WebRequest request) {
        return ResponseEntity.badRequest().body(new GenericResponse(ex.getMessage()));
    }

}
