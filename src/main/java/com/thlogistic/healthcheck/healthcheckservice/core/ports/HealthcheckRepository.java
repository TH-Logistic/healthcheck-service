package com.thlogistic.healthcheck.healthcheckservice.core.ports;


import com.thlogistic.healthcheck.healthcheckservice.infrastructure.persistence.entities.HealthcheckEntity;

import java.util.Optional;

public interface HealthcheckRepository {
    String insert(HealthcheckEntity healthcheck);

    Optional<HealthcheckEntity> findByJobId(String id);
}
