package com.horustek.gda.infra.seguridad.jwt;

import com.horustek.gda.services.seguridad.usuario.UsuarioService;
import com.horustek.gda.shared.dto.seguridad.GdaUsuarioDTO;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class InfoAdicionalToken implements TokenEnhancer {

    private final UsuarioService usuarioService;

    public InfoAdicionalToken(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

        GdaUsuarioDTO usuario = usuarioService.findByUsername(authentication.getName());
        Map<String, Object> info = new HashMap<>();
        info.put("id", usuario.getId());
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
        return accessToken;
    }

}
