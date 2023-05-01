package com.thlogistic.healthcheck.healthcheckservice.core.usecases;

public interface BaseUseCase<Request, Response> {
    Response execute(Request request);
}
