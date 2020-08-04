package com.horustek.gda.infra.exceptions;

import com.homiefoo.platformbackend.core.utils.json.Util_Json;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) {
        httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        httpServletResponse.setContentType("application/json");

        ApiError apiError = new ApiError(HttpStatus.UNAUTHORIZED);
        apiError.setMessage(e.getMessage());
        apiError.setDebugMessage(e.getMessage());
        apiError.setTokenExpired(e.getMessage().startsWith("Access token expired"));

        try {
            httpServletResponse.getOutputStream()
                    .println(Util_Json.toJSON(apiError));
        } catch (IOException e1) {
            throw new RuntimeException(e1);
        }
    }
}
