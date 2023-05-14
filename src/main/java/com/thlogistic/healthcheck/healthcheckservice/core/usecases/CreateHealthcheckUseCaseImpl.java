package com.thlogistic.healthcheck.healthcheckservice.core.usecases;

import com.thlogistic.healthcheck.healthcheckservice.adapters.dtos.CreateHealthcheckRequest;
import com.thlogistic.healthcheck.healthcheckservice.adapters.dtos.CreateHealthcheckResponse;
import com.thlogistic.healthcheck.healthcheckservice.aop.exception.InvalidDateTimeFormatException;
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

    @Override
    public CreateHealthcheckResponse execute(CreateHealthcheckRequest request) {
        HealthcheckDetail healthcheckDetail = new HealthcheckDetail(
                request.getIsTiresOk(),
                request.getIsLightOk(),
                request.getIsBrakeOk(),
                request.getIsFluidLevelOk(),
                request.getIsBatteryOk(),
                request.getIsWiperOk()
        );
        if (!DateTimeFormatter.checkDateTimeFormat(request.getCreatedAt())) {
            throw new InvalidDateTimeFormatException("Invalid datetime format");
        }
        HealthcheckEntity entity = new HealthcheckEntity(
                request.getJobId(),
                request.getNote(),
                healthcheckDetail,
                request.getCreatedAt()
        );
        String id = repository.insert(entity);
        return new CreateHealthcheckResponse(id);
    }
}
