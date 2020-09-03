package com.horustek.gda.shared.dto.seguridad;

import com.horustek.gda.model.domain.GdaRol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AsignarRolesDTO {
    String id;
    List<GdaRol> roles;
}
