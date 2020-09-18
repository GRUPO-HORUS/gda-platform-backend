package com.horustek.gda.shared.dto.gestionalertas;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DashboardDTO {

    private Long totalElementos;
    private Long pendientesEtiquetado;
    private Long pendientesAprobacion;
}
