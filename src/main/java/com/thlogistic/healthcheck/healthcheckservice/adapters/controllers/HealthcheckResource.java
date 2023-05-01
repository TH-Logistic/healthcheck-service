package com.thlogistic.healthcheck.healthcheckservice.adapters.controllers;

import com.thlogistic.healthcheck.healthcheckservice.adapters.dtos.CreateHealthcheckRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/healthcheck")
interface HealthcheckResource {
    @GetMapping("/{jobId}")
    ResponseEntity<Object> getHealthcheck(@PathVariable String jobId);

    @PostMapping
    ResponseEntity<Object> createHealthcheck(@Valid @RequestBody CreateHealthcheckRequest request);
}
