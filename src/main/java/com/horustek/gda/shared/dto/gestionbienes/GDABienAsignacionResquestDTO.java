package com.horustek.gda.shared.dto.gestionbienes;

import com.horustek.gda.model.domain.enumeradores.BienTipoAsignacionEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GDABienAsignacionResquestDTO {

    private BienTipoAsignacionEnum tipoAsignacion;
    private String idUsuario;
}
