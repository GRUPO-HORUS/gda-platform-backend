package com.horustek.gda.infra.seguridad.jwt;

import org.springframework.security.core.Authentication;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.authentication.BearerTokenExtractor;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import javax.servlet.http.HttpServletRequest;

public class CustomBearerTokenExtractor extends BearerTokenExtractor {

    private TokenStore tokenStore;

    public CustomBearerTokenExtractor() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new CustomJwtAccessTokenConverter();
        tokenStore = new JwtTokenStore(jwtAccessTokenConverter);
    }

    @Override
    public Authentication extract(HttpServletRequest request) {
        Authentication authentication = super.extract(request);
        if (authentication != null && request.getRequestURI().endsWith("/public")) {
            //Ignore expiration and token errors for public endpoints
            try {
                DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken)tokenStore.readAccessToken(authentication.getName());
                if (token.isExpired())
                    return null;
            }
            catch (InvalidTokenException e) {
                return null;
            }
        }
        return authentication;
    }
}

