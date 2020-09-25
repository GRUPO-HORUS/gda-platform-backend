package com.horustek.gda.shared.dto.gestioninformes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GDAInformesDTO {

    private String nombre;
    private String apellidos;
    private String cedula;
    private String correo;
    private String usuario;
}
