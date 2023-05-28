package com.thlogistic.healthcheck.healthcheckservice.core.usecases;

import com.thlogistic.healthcheck.healthcheckservice.adapters.dtos.BaseTokenRequest;
import com.thlogistic.healthcheck.healthcheckservice.adapters.dtos.CreateHealthcheckRequest;
import com.thlogistic.healthcheck.healthcheckservice.adapters.dtos.CreateHealthcheckResponse;
import com.thlogistic.healthcheck.healthcheckservice.aop.exception.InvalidJobException;
import com.thlogistic.healthcheck.healthcheckservice.client.job.JobClient;
import com.thlogistic.healthcheck.healthcheckservice.core.ports.HealthcheckRepository;
import com.thlogistic.healthcheck.healthcheckservice.infrastructure.persistence.entities.HealthcheckDetail;
import com.thlogistic.healthcheck.healthcheckservice.infrastructure.persistence.entities.HealthcheckEntity;
import com.thlogistic.healthcheck.healthcheckservice.utils.DateTimeFormatter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateHealthcheckUseCaseImpl implements CreateHealthcheckUseCase {

    private final HealthcheckRepository repository;
    private final JobClient jobClient;

    @Override
    public CreateHealthcheckResponse execute(BaseTokenRequest<CreateHealthcheckRequest> baseTokenRequest) {
        String token = baseTokenRequest.getToken();
        CreateHealthcheckRequest request = baseTokenRequest.getRequestContent();
        // Check if job id is valid
        try {
            jobClient.checkIfJobExist(token, request.getJobId());
        } catch (Exception e) {
            throw new InvalidJobException("Job not found or driver does not start the job");
        }

        HealthcheckDetail healthcheckDetail = new HealthcheckDetail(
                request.getIsTiresOk(),
                request.getIsLightOk(),
                request.getIsBrakeOk(),
                request.getIsFluidLevelOk(),
                request.getIsBatteryOk(),
                request.getIsWiperOk()
        );
        HealthcheckEntity entity = new HealthcheckEntity(
                request.getJobId(),
                request.getNote(),
                healthcheckDetail,
                DateTimeFormatter.getCurrentTimeFormatted()
        );
        String id = repository.insert(entity);
        return new CreateHealthcheckResponse(id);
    }
}
