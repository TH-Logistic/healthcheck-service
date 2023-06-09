package com.thlogistic.healthcheck.healthcheckservice.config;

import com.thlogistic.healthcheck.healthcheckservice.client.auth.AuthorizationClient;
import com.thlogistic.healthcheck.healthcheckservice.client.job.JobClient;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {

    private static final String httpPath = "http://";
    private static final String domainUrl = System.getenv("DOMAIN_URL");

    public static final String AUTHORIZATION_BASE_URL = httpPath + domainUrl + ":8000";
    public static final String JOB_BASE_URL = httpPath + domainUrl + ":8085";

    @Bean
    public AuthorizationClient authorizationClient() {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(AuthorizationClient.class, AUTHORIZATION_BASE_URL);
    }

    @Bean
    public JobClient jobClient() {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(JobClient.class, JOB_BASE_URL);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
