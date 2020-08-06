package com.horustek.gda.shared.mapper;

import com.horustek.gda.model.domain.GdaRol;
import com.horustek.gda.model.domain.GdaUsuario;
import com.horustek.gda.shared.dto.seguridad.GdaRolDTO;
import com.horustek.gda.shared.dto.seguridad.GdaUsuarioDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper()
public interface GdaRolMapper {

    GdaRolDTO toGdaRolDTO(GdaRol gdaRol);
    List<GdaRolDTO> toGdaRolDTOs(List<GdaRol> gdaRoles);
}
