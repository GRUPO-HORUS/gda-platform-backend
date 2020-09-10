package com.horustek.gda.shared.dto.seguridad;

import com.horustek.gda.model.domain.GdaRol;
import com.horustek.gda.model.domain.GdaUnidad;
import com.horustek.gda.shared.dto.gestionEntidades.GdaUnidadDTO;
import lombok.Data;

import java.util.List;

@Data
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
