package com.horustek.gda.shared.dto.gestionbienes;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GdaCategoriaBienDTO {

    private String id;
    private String descripcion;
    private String codigo;
    @JsonProperty("categoriaPadre")
    private GdaCategoriaBienDTO gdaCategoriaBienId;
}
