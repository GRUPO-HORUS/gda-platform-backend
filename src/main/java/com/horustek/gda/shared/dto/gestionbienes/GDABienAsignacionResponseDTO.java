package com.horustek.gda.shared.dto.gestionbienes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.horustek.gda.model.domain.enumeradores.BienTipoAsignacionEnum;
import com.horustek.gda.model.domain.enumeradores.EstadoInactividadEnum;
import com.horustek.gda.shared.dto.seguridad.GdaUsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GDABienAsignacionResponseDTO {

    private BienTipoAsignacionEnum tipoAsignacion;
    private EstadoInactividadEnum estado;
    @JsonProperty("usuario")
    private GdaUsuarioDTO gdaUsuarioId;
}
