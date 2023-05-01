package com.thlogistic.healthcheck.healthcheckservice.aop.exception;

public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String message) {
        super(message);
    }
}
