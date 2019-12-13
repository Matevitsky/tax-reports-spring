package com.matevytskyi.taxreports.config.security.jwt;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private static final String JWT_AUTHENTICATION_FAILED = "Jwt authentication failed";


    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        log.info(JWT_AUTHENTICATION_FAILED + authException);

        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, JWT_AUTHENTICATION_FAILED);

    }

}
