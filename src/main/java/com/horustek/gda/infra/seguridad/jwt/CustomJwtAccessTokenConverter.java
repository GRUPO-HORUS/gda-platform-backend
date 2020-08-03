package com.horustek.gda.infra.seguridad.jwt;

import com.horustek.gda.infra.seguridad.oauth.CustomUserDetail;
import com.horustek.gda.model.domain.GdaUsuario;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.HashMap;
import java.util.Map;

public class CustomJwtAccessTokenConverter extends JwtAccessTokenConverter {

    public CustomJwtAccessTokenConverter() {
        super();
        setSigningKey(JwtConfig.RSA_PRIVADA);
        setVerifierKey(JwtConfig.RSA_PUBLICA);
        setVerifier(new RsaVerifier(JwtConfig.RSA_PUBLICA));
    }

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        CustomUserDetail userDetail = (CustomUserDetail) authentication.getUserAuthentication().getPrincipal();
        final Map<String, Object> additionalInfo = new HashMap<>();
        //Add user id to token
        additionalInfo.put("user_id", userDetail.getUserId());
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        return super.enhance(accessToken, authentication);
    }

}
