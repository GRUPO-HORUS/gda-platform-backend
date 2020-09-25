package com.horustek.gda.shared.dto.gestionbienes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GDABienTipoDTO {

    private String id;
    private String descripcion;

}
