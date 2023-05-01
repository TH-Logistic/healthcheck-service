package com.thlogistic.healthcheck.healthcheckservice.infrastructure.persistence.entities;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HealthcheckDetail {
    boolean isTiresOk;
    boolean isLightOk;
    boolean isBrakeOk;
    boolean isFluidLevelOk;
    boolean isBatteryOk;
    boolean isWiperOk;

    public boolean isHealthcheckOk() {
        return isTiresOk
                && isLightOk
                && isBrakeOk
                && isFluidLevelOk
                && isBatteryOk
                && isWiperOk;
    }
}
