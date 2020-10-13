package com.horustek.gda.shared.dto.gestionbienes;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GdaCategoriaBienHijaDTO {

    private String id;
    private String descripcion;
    private String codigo;
//    private List<GdaCategoriaBienHijaDTO> gdaCategoriaBienList;

}
