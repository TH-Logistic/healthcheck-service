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
    boolean isHealthcheckOk;
    boolean isTiresOk;
    boolean isLightOk;
    boolean isBrakeOk;
    boolean isFluidLevelOk;
    boolean isBatteryOk;
    boolean isWiperOk;
}
