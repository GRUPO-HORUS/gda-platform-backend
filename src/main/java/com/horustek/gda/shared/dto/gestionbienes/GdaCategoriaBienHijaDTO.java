package com.horustek.gda.shared.dto.gestionbienes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.horustek.gda.model.domain.GdaAtributoCategoriaBien;
import com.horustek.gda.model.domain.GdaBien;
import com.horustek.gda.model.domain.GdaCategoriaBien;
import com.horustek.gda.model.domain.GdaSolicitudMovBienPorCategoria;
import lombok.Data;

import java.util.List;

@Data
public class GdaCategoriaBienHijaDTO {

    @JsonIgnore
    private String id;
    @JsonIgnore
    private String descripcion;
    @JsonIgnore
    private String codigo;
    @JsonIgnore
    private List<GdaAtributoCategoriaBien> gdaAtributoCategoriaBienList;
    private List<GdaCategoriaBien> gdaCategoriaBienList;
    private List<GdaSolicitudMovBienPorCategoria> gdaSolicitudMovBienPorCategoriaList;
    private List<GdaBien> gdaBienList;

}
