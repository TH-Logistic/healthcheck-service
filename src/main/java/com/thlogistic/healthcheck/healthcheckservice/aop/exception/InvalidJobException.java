package com.thlogistic.healthcheck.healthcheckservice.aop.exception;

public class InvalidJobException extends RuntimeException {
    public InvalidJobException(String message) {
        super(message);
    }
}
