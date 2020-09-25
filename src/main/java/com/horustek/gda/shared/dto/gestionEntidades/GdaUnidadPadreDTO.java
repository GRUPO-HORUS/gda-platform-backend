package com.horustek.gda.shared.dto.gestionEntidades;

import com.horustek.gda.shared.dto.seguridad.GdaUsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GdaUnidadPadreDTO {

    private String id;
    private String nombre;
    private GdaTipoUnidadDTO gdaTipoUnidadId;
}
