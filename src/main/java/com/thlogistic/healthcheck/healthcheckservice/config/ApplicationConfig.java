package com.thlogistic.healthcheck.healthcheckservice.config;

import com.thlogistic.healthcheck.healthcheckservice.client.AuthorizationClient;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {

    private static String domainUrl = System.getenv("DOMAIN_URL");

    public static final String AUTHORIZATION_BASE_URL = "http://" + domainUrl + ":8000";

    @Bean
    public AuthorizationClient authorizationClient() {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(AuthorizationClient.class, AUTHORIZATION_BASE_URL);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
