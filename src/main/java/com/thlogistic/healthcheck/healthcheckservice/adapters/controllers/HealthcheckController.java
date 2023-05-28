package com.thlogistic.healthcheck.healthcheckservice.adapters.controllers;

import com.thlogistic.healthcheck.healthcheckservice.adapters.dtos.BaseTokenRequest;
import com.thlogistic.healthcheck.healthcheckservice.adapters.dtos.CreateHealthcheckRequest;
import com.thlogistic.healthcheck.healthcheckservice.adapters.dtos.CreateHealthcheckResponse;
import com.thlogistic.healthcheck.healthcheckservice.adapters.dtos.GetHealthcheckResponse;
import com.thlogistic.healthcheck.healthcheckservice.core.usecases.CreateHealthcheckUseCase;
import com.thlogistic.healthcheck.healthcheckservice.core.usecases.GetHealthcheckUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HealthcheckController extends BaseController implements HealthcheckResource {

    private final CreateHealthcheckUseCase createHealthcheckUseCase;
    private final GetHealthcheckUseCase getHealthcheckUseCase;

    @Override
    public ResponseEntity<Object> getHealthcheck(String jobId) {
        GetHealthcheckResponse response = getHealthcheckUseCase.execute(jobId);
        return successResponse(response, null);
    }

    @Override
    public ResponseEntity<Object> createHealthcheck(String token, CreateHealthcheckRequest request) {
        CreateHealthcheckResponse response = createHealthcheckUseCase.execute(
                new BaseTokenRequest<>(
                        token,
                        request
                )
        );
        return successResponse(response, null);
    }
}
