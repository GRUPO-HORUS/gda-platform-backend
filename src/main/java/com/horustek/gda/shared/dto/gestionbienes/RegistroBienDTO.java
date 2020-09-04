package com.horustek.gda.shared.dto.gestionbienes;

import com.horustek.gda.model.domain.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistroBienDTO {

    private String detalle;
    private Date fechaIncorporacion;
    private double valorIncorporacion;
    private List<GdaBienFijoDatos> gdaBienFijoDatosList;
    private List<GdaSolictudMovBienEspefico> gdaSolictudMovBienEspeficoList;
    private List<GdaBien> gdaBienList;
    private GdaBien gdaBienPadreId;
    private GdaCategoriaBien gdaCategoriaBienId;
    private GdaUnidad gdaUnidadUbicacionId;
    private GdaUsuario gdaUsuarioResponsableId;
    private GdaBienTipo gdaBienTipo;
}
