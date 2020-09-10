package com.horustek.gda.infra.seguridad.jwt;

import com.horustek.gda.model.domain.GdaUnidad;
import com.horustek.gda.services.seguridad.usuario.IUsuarioService;
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

    private final IUsuarioService usuarioService;

    public InfoAdicionalToken(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

        GdaUsuarioDTO usuario = usuarioService.findByUsername(authentication.getName());
        GdaUnidad gdaUnidadALaQuePerteneceUsuarioLogueado = usuarioService.findUnidadFromUser(authentication.getName());


        Map<String, Object> info = new HashMap<>();
        info.put("nombre", usuario.getNombre());
        info.put("apellidos", usuario.getApellidos());
        info.put("correo", usuario.getEmail());
        info.put("telefono", usuario.getTelefono());
        info.put("nombreUsuario", usuario.getNombreUsuario());
        info.put("idUsuario", usuario.getId());
        info.put("unidad", gdaUnidadALaQuePerteneceUsuarioLogueado.getNombre());
        info.put("entidad", gdaUnidadALaQuePerteneceUsuarioLogueado.getGdaEntidadId().getNombre());
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
        return accessToken;
    }

}
