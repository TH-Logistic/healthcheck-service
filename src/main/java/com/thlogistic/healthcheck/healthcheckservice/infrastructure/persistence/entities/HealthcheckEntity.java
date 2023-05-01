package com.thlogistic.healthcheck.healthcheckservice.infrastructure.persistence.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document("healthcheck")
public class HealthcheckEntity {
    @Id
    String id;

    String jobId;

    String note;

    HealthcheckDetail healthcheckDetail;

    String createdAt;

    public HealthcheckEntity(String jobId, String note, HealthcheckDetail healthcheckDetail, String createdAt) {
        this.jobId = jobId;
        this.note = note;
        this.healthcheckDetail = healthcheckDetail;
        this.createdAt = createdAt;
    }
}
