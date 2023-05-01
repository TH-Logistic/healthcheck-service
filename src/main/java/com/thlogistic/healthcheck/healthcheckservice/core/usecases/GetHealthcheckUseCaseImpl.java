package com.thlogistic.healthcheck.healthcheckservice.core.usecases;

import com.thlogistic.healthcheck.healthcheckservice.adapters.dtos.CreateHealthcheckRequest;
import com.thlogistic.healthcheck.healthcheckservice.adapters.dtos.CreateHealthcheckResponse;
import com.thlogistic.healthcheck.healthcheckservice.adapters.dtos.GetHealthcheckResponse;
import com.thlogistic.healthcheck.healthcheckservice.aop.exception.DataNotFoundException;
import com.thlogistic.healthcheck.healthcheckservice.core.ports.HealthcheckRepository;
import com.thlogistic.healthcheck.healthcheckservice.infrastructure.persistence.entities.HealthcheckDetail;
import com.thlogistic.healthcheck.healthcheckservice.infrastructure.persistence.entities.HealthcheckEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetHealthcheckUseCaseImpl implements GetHealthcheckUseCase {

    private final HealthcheckRepository repository;

    @Override
    public GetHealthcheckResponse execute(String jobId) {
        Optional<HealthcheckEntity> healthcheckEntity = repository.findByJobId(jobId);
        if (healthcheckEntity.isEmpty()) {
            throw new DataNotFoundException("Healthcheck");
        }
        HealthcheckEntity result = healthcheckEntity.get();
        return new GetHealthcheckResponse(
                result.getId(),
                result.getNote(),
                result.getCreatedAt(),
                result.getHealthcheckDetail().isHealthcheckOk(),
                result.getHealthcheckDetail().isTiresOk(),
                result.getHealthcheckDetail().isLightOk(),
                result.getHealthcheckDetail().isBrakeOk(),
                result.getHealthcheckDetail().isFluidLevelOk(),
                result.getHealthcheckDetail().isBatteryOk(),
                result.getHealthcheckDetail().isWiperOk()
        );
    }
}
