package com.thlogistic.healthcheck.healthcheckservice.adapters.dtos;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.thlogistic.healthcheck.healthcheckservice.infrastructure.persistence.entities.HealthcheckDetail;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateHealthcheckRequest {

    @NotBlank(message = "Invalid job ID")
    String jobId;

    @NotNull(message = "Invalid tires' status value")
    Boolean isTiresOk;

    @NotNull(message = "Invalid light's status value")
    Boolean isLightOk;

    @NotNull(message = "Invalid brake's status value")
    Boolean isBrakeOk;

    @NotNull(message = "Invalid fluid level's status value")
    Boolean isFluidLevelOk;

    @NotNull(message = "Invalid battery's status value")
    Boolean isBatteryOk;

    @NotNull(message = "Invalid wiper's status value")
    Boolean isWiperOk;

    String note;

    @NotBlank(message = "Invalid time created")
    String createdAt;
}
