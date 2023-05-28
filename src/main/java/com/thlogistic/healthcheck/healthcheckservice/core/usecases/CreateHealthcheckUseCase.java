package com.thlogistic.healthcheck.healthcheckservice.core.usecases;


import com.thlogistic.healthcheck.healthcheckservice.adapters.dtos.BaseTokenRequest;
import com.thlogistic.healthcheck.healthcheckservice.adapters.dtos.CreateHealthcheckRequest;
import com.thlogistic.healthcheck.healthcheckservice.adapters.dtos.CreateHealthcheckResponse;

public interface CreateHealthcheckUseCase extends BaseUseCase<BaseTokenRequest<CreateHealthcheckRequest>, CreateHealthcheckResponse> {
}
