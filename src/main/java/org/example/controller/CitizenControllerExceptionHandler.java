package org.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.UUID;

@ControllerAdvice
public class CitizenControllerExceptionHandler {

    @ExceptionHandler(value = {IllegalArgumentException.class})
    public ResponseEntity<String> resourceNotFoundException(IllegalArgumentException exception) {
        String id = UUID.randomUUID().toString();
        String message = "Exception: " + exception.getMessage() + " incident id: " + id;
        System.out.println(message);
        return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity<String> internalError(RuntimeException exception) {
        String id = UUID.randomUUID().toString();
        String message = "Exception: " + exception.getMessage() + " incident id: " + id;
        System.out.println(message);
        return new ResponseEntity<String>("Please contact adminstrator. Incident id" + id, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
