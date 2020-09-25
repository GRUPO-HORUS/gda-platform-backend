package com.horustek.gda.shared.mapper.gestiondebienes;

import com.horustek.gda.model.domain.GdaAtributoCategoriaBien;
import com.horustek.gda.model.domain.GdaBien;
import com.horustek.gda.model.domain.GdaCategoriaBien;
import com.horustek.gda.model.domain.GdaSolicitudMovBienPorCategoria;
import com.horustek.gda.shared.dto.gestionbienes.GDABienDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper()
public interface GdaBienMapper {

    GDABienDTO toGdaBienDTO(GdaBien gdaBien);
    List<GDABienDTO> toGdaBienDTOs(List<GdaBien> gdaBiens);
}
