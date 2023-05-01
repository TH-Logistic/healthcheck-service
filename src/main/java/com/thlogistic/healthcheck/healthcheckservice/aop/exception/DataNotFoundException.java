package com.thlogistic.healthcheck.healthcheckservice.aop.exception;

public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException(String modelName) {
        super(String.format("Cannot find %s", modelName));
    }
}
