package com.horustek.gda.infra.exceptions;
import com.horustek.gda.infra.utils.JsonUtils;
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
                    .println(JsonUtils.toJSON(apiError));
        } catch (IOException e1) {
            throw new RuntimeException(e1);
        }
    }
}
