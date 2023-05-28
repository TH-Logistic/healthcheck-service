package com.thlogistic.healthcheck.healthcheckservice.client.job;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetJobIfExistResponse {
    String id;
    Integer status;
}
