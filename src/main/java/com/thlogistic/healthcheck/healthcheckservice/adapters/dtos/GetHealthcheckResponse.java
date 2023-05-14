package com.thlogistic.healthcheck.healthcheckservice.adapters.dtos;

import com.thlogistic.healthcheck.healthcheckservice.infrastructure.persistence.entities.HealthcheckDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetHealthcheckResponse {
    String id;
    String note;
    String createdAt;
    Boolean isHealthcheckOk;
    Boolean isTiresOk;
    Boolean isLightOk;
    Boolean isBrakeOk;
    Boolean isFluidLevelOk;
    Boolean isBatteryOk;
    Boolean isWiperOk;
}
