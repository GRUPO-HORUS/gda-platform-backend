package com.horustek.gda.shared.mapper.seguridad;

import com.horustek.gda.model.domain.GdaUsuario;
import com.horustek.gda.shared.dto.seguridad.GdaUsuarioDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper()
public interface GdaUsuarioMapper {

    GdaUsuarioDTO toGdaUsuarioDTO(GdaUsuario gdaUsuario);
    List<GdaUsuarioDTO> toGdaUsuarioDTOs(List<GdaUsuario> gdaUsuarios);
}
