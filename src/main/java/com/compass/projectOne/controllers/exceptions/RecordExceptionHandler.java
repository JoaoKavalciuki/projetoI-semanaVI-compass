package com.compass.projectOne.controllers.exceptions;

import com.compass.projectOne.services.exceptions.DatabaseException;
import com.compass.projectOne.services.exceptions.RecordNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class RecordExceptionHandler {
    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<StandardError> recordNotFound(RecordNotFoundException exception, HttpServletRequest request){
        String errorMessage = "Record not found";

        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError error = new StandardError(Instant.now(), status.value(), errorMessage, exception.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }
    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> databaseException(DatabaseException exception, HttpServletRequest request){
        String errorMessage = "Database error";

        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError error = new StandardError(Instant.now(), status.value(), errorMessage, exception.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }
}
