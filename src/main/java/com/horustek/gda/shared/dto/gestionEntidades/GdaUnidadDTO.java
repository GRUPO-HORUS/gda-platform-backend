package com.horustek.gda.shared.dto.gestionEntidades;

import com.horustek.gda.model.domain.*;
import com.horustek.gda.shared.dto.seguridad.GdaUsuarioDTO;
import com.horustek.gda.shared.mapper.gestionentidades.GdaTipoUnidadMapper;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GdaUnidadDTO {

    private String id;
    private String nombre;
    private GdaEntidadDTO gdaEntidadId;
    private GdaTipoUnidadDTO gdaTipoUnidadId;
    private List<GdaUnidadDTO> gdaUnidadList;
    private GdaUnidadDTO gdaUnidadPadreId;
    private List<GdaUsuarioDTO> gdaUsuarioList;
}
