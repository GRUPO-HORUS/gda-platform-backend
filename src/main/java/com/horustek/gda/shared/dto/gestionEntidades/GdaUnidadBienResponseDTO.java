package com.horustek.gda.shared.dto.gestionEntidades;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GdaUnidadBienResponseDTO {

    private String id;
    private String nombre;
    private GdaEntidadDTO gdaEntidadId;
    private GdaTipoUnidadDTO gdaTipoUnidadId;
    private GdaUnidadBienResponseDTO gdaUnidadPadreId;
}
