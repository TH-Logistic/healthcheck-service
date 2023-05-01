package com.thlogistic.healthcheck.healthcheckservice.adapters.controllers;

import com.thlogistic.healthcheck.healthcheckservice.adapters.dtos.BaseResponse;
import org.springframework.http.ResponseEntity;

public class BaseController {
    public ResponseEntity<Object> successResponse(Object data, String message) {
        BaseResponse<Object> response = new BaseResponse<>();
        response.setSuccess(true);
        response.setMessage(message);
        response.setData(data);
        return ResponseEntity.ok(response);
    }
}
