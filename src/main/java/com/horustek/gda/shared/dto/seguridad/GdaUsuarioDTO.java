package com.horustek.gda.shared.dto.seguridad;

import com.horustek.gda.model.domain.GdaRol;
import lombok.Data;
import java.util.List;

@Data
public class GdaUsuarioDTO {
    private String id;
    private String nombreUsuario;
    private String email;
    private List<GdaRol> roles;
}
