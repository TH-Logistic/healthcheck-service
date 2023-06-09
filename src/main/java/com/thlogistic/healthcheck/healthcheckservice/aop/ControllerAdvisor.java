package com.thlogistic.healthcheck.healthcheckservice.aop;

import com.thlogistic.healthcheck.healthcheckservice.adapters.dtos.ErrorResponse;
import com.thlogistic.healthcheck.healthcheckservice.aop.exception.DataNotFoundException;
import com.thlogistic.healthcheck.healthcheckservice.aop.exception.InvalidDateTimeFormatException;
import com.thlogistic.healthcheck.healthcheckservice.aop.exception.InvalidJobException;
import com.thlogistic.healthcheck.healthcheckservice.aop.exception.UnauthorizedException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String message = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        Map<String, Object> response = ErrorResponse.errorResponse(message, null);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(
            DataNotFoundException ex, WebRequest request) {
        Map<String, Object> response = ErrorResponse.errorResponse(ex.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<Object> handleUnauthorizedException(
            UnauthorizedException ex, WebRequest request) {
        Map<String, Object> response = ErrorResponse.errorResponse(ex.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(InvalidDateTimeFormatException.class)
    public ResponseEntity<Object> handleInvalidDateTimeFormatException(
            InvalidDateTimeFormatException ex, WebRequest request) {
        Map<String, Object> response = ErrorResponse.errorResponse(ex.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidJobException.class)
    public ResponseEntity<Object> handleInvalidJobException(
            InvalidJobException ex, WebRequest request) {
        Map<String, Object> response = ErrorResponse.errorResponse(ex.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}

