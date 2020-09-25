package com.horustek.gda.shared.dto.gestionEntidades;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GdaUnidadHijaDTO {

    private String id;
    private String nombre;
    private GdaTipoUnidadDTO gdaTipoUnidadId;
}
