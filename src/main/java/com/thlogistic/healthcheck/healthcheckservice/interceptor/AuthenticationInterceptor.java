package com.thlogistic.healthcheck.healthcheckservice.interceptor;

import com.thlogistic.healthcheck.healthcheckservice.adapters.dtos.BaseResponse;
import com.thlogistic.healthcheck.healthcheckservice.aop.exception.UnauthorizedException;
import com.thlogistic.healthcheck.healthcheckservice.client.auth.AuthorizationClient;
import com.thlogistic.healthcheck.healthcheckservice.client.auth.PermissionDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthenticationInterceptor implements HandlerInterceptor {
    private static final String AUTHORIZATION_HEADER = "Authorization";
    private final AuthorizationClient authorizationClient;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        if (request.getMethod().equals("OPTIONS")) {
            return true;
        }

        String token = request.getHeader(AUTHORIZATION_HEADER);
        List<String> roles = List.of("admin");

        if (token != null) {
            try {
                BaseResponse<PermissionDto> permissionResponse = authorizationClient.checkPermission(token, roles);
                if (!permissionResponse.getSuccess()) {
                    throw new UnauthorizedException("Invalid token credential");
                }
            } catch (Exception e) {
                throw new UnauthorizedException("Invalid token credential");
            }
        } else {
            System.out.println("justin else");
            throw new UnauthorizedException("Invalid token credential");
        }
        return true;
    }
}
