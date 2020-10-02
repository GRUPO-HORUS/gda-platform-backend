package com.horustek.gda.shared.dto.gestionEntidades;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GdaUnidadBienResponseDTO {

    private String id;
    private String nombre;
    private GdaTipoUnidadDTO gdaTipoUnidadId;
    private GdaUnidadBienResponseDTO gdaUnidadPadreId;
    @JsonProperty("unidades_hijas")
    private List<GdaUnidadHijaDTO> gdaUnidadList;

}
