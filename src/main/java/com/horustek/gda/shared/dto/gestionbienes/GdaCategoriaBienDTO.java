package com.horustek.gda.shared.dto.gestionbienes;


import com.horustek.gda.model.domain.GdaAtributoCategoriaBien;
import com.horustek.gda.model.domain.GdaBien;
import com.horustek.gda.model.domain.GdaCategoriaBien;
import com.horustek.gda.model.domain.GdaSolicitudMovBienPorCategoria;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Data
public class GdaCategoriaBienDTO {

    private String id;
    private String descripcion;
    private String codigo;
    private List<GdaAtributoCategoriaBien> gdaAtributoCategoriaBienList;
    private List<GdaCategoriaBien> gdaCategoriaBienList;
    private GdaCategoriaBien gdaCategoriaBienId;
    private List<GdaSolicitudMovBienPorCategoria> gdaSolicitudMovBienPorCategoriaList;
    private List<GdaBien> gdaBienList;

}
