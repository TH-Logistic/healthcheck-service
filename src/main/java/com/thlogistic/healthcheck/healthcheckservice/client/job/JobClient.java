package com.thlogistic.healthcheck.healthcheckservice.client.job;

import com.thlogistic.healthcheck.healthcheckservice.adapters.dtos.BaseResponse;
import com.thlogistic.healthcheck.healthcheckservice.client.auth.PermissionDto;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface JobClient {
    @RequestLine("GET /api/v1/job/{jobId}/exists")
    @Headers({
            "Content-Type: application/json",
            "Authorization: {token}"
    })
    BaseResponse<GetJobIfExistResponse> checkIfJobExist(@Param("token") String token, @Param("token") String jobId);
}
