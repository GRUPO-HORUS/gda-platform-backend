package com.horustek.gda.shared.dto.gestionbienes;

import com.horustek.gda.model.domain.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AtributoValorBienDTO {

    private String atributo;
    private String valor;

}
