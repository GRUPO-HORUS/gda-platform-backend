package com.horustek.gda.shared.dto.gestionbienes;

import com.horustek.gda.model.domain.enumeradores.BienEstadoConservacionEnum;
import com.horustek.gda.model.domain.enumeradores.BienExistenciaInventarioEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistroBienDTO {

    private BienEstadoConservacionEnum estadoConservacion;
    private String detalle;
    private BienExistenciaInventarioEnum existenciaInventario;
    private String tipoBienId;
    private String categoriaBienId;
    private String unidadUbicacionId;
    private String usuarioAprobadorId;
    private String usuarioAsignadoId;
    private String usuarioControlId;
    private String usuarioRegistroId;
    private String usuarioResponsableId;
    private double valorIncorporacion;
    private List<AtributoFormularioBienRequestDTO> atributosDinamicos;


}
