package com.horustek.gda.shared.dto.gestionbienes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GdaDetalleAtributoCategoriaFormDTO {

   List<AtributoFormularioBienDTO> atributoFormularioBien;
}
