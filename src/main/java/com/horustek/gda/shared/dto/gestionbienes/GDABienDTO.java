package com.horustek.gda.shared.dto.gestionbienes;

import com.horustek.gda.model.domain.GdaBienTipo;
import com.horustek.gda.model.domain.GdaCategoriaBien;
import com.horustek.gda.shared.dto.gestionEntidades.GdaUnidadDTO;
import com.horustek.gda.shared.dto.seguridad.GdaUsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GDABienDTO {

    private String id;
    private String rotulado;
    private String detalle;
    private Date fechaIncorporacion;
    private double valorIncorporacion;
    private GdaCategoriaBienDTO gdaCategoriaBienId;
    private GdaUnidadDTO gdaUnidadUbicacionId;
    private GdaUsuarioDTO gdaUsuarioResponsableId;
    private GDABienTipoDTO gdaBienTipo;

}
