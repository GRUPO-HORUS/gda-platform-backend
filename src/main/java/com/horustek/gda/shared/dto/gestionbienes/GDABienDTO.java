package com.horustek.gda.shared.dto.gestionbienes;

import com.horustek.gda.shared.dto.gestionEntidades.GdaUnidadBienResponseDTO;
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
    private String bienEstadoConservacion;
    private String existenciaInventario;
    private GDABienTipoDTO gdaBienTipo;
    private GdaCategoriaBienDTO gdaCategoriaBienId;
    private GdaUnidadBienResponseDTO gdaUnidadUbicacionId;
    private GdaUsuarioDTO gdaUsuarioResponsableId;
}
