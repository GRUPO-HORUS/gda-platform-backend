package com.horustek.gda.shared.dto.gestionbienes;

import com.horustek.gda.model.domain.enumeradores.TipoDatoAtributosEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AtributoFormularioBienRequestDTO {

    private String idAtributoCategoriaBien;
    private String valor;

}
