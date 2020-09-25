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
public class GdaUnidadRequestDTO {

    private String id;
    private String nombre;
    private GdaEntidadDTO gdaEntidadId;
    private GdaTipoUnidadDTO gdaTipoUnidadId;
    private List<GdaUnidadRequestDTO> gdaUnidadList;
    private GdaUnidadRequestDTO gdaUnidadPadreId;
    private List<GdaUsuarioDTO> gdaUsuarioList;
}
