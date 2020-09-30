package com.horustek.gda.shared.dto.gestionbienes;

import com.horustek.gda.model.domain.enumeradores.BienTipoAsignacionEnum;
import com.horustek.gda.model.domain.enumeradores.EstadoInactividadEnum;
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
public class GDABienAsignacionDTO {

    private BienTipoAsignacionEnum tipoAsignacion;
    private EstadoInactividadEnum estado;
    private String idBien;
    private String idUsuario;
}
