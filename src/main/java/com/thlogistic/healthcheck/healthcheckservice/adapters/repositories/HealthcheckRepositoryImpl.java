package com.thlogistic.healthcheck.healthcheckservice.adapters.repositories;

import com.thlogistic.healthcheck.healthcheckservice.core.ports.HealthcheckRepository;
import com.thlogistic.healthcheck.healthcheckservice.infrastructure.persistence.entities.HealthcheckEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class HealthcheckRepositoryImpl implements HealthcheckRepository {
    private final MongoHealthcheckRepository repository;

    @Override
    public String insert(HealthcheckEntity healthcheck) {
        return repository.insert(healthcheck).getId();
    }

    @Override
    public Optional<HealthcheckEntity> findByJobId(String jobId) {
        return repository.findByJobId(jobId);
    }
}
