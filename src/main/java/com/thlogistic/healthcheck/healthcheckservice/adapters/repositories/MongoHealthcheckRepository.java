package com.thlogistic.healthcheck.healthcheckservice.adapters.repositories;

import com.thlogistic.healthcheck.healthcheckservice.infrastructure.persistence.entities.HealthcheckEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MongoHealthcheckRepository extends MongoRepository<HealthcheckEntity, String> {
    Optional<HealthcheckEntity> findByJobId(String jobId);
}
