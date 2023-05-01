package com.thlogistic.healthcheck.healthcheckservice.core.usecases;


import com.thlogistic.healthcheck.healthcheckservice.adapters.dtos.CreateHealthcheckRequest;
import com.thlogistic.healthcheck.healthcheckservice.adapters.dtos.CreateHealthcheckResponse;
import com.thlogistic.healthcheck.healthcheckservice.adapters.dtos.GetHealthcheckResponse;

public interface GetHealthcheckUseCase extends BaseUseCase<String, GetHealthcheckResponse> {
}
