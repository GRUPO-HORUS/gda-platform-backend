package com.horustek.gda.shared.dto.seguridad;

import com.horustek.gda.model.domain.GdaRol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GdaUsuarioDTO {
    private String id;
    private String nombreUsuario;
    private String email;
    private String nombre;
    private String apellidos;
    private String cedula;
    private String telefono;
    private String celular;
    private List<GdaRol> roles;
}
