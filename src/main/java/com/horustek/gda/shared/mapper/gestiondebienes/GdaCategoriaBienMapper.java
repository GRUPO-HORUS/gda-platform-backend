package com.horustek.gda.shared.mapper.gestiondebienes;

import com.horustek.gda.model.domain.GdaCategoriaBien;
import com.horustek.gda.model.domain.GdaUsuario;
import com.horustek.gda.shared.dto.gestionbienes.GdaCategoriaBienDTO;
import com.horustek.gda.shared.dto.seguridad.GdaUsuarioDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper()
public interface GdaCategoriaBienMapper {

    GdaCategoriaBienDTO toGdaCategoriaBienDTO(GdaCategoriaBien gdaCategoriaBien);
    List<GdaCategoriaBienDTO> toGdaCategoriaBienDTOs(List<GdaCategoriaBien> gdaCategoriaBiens);
}
