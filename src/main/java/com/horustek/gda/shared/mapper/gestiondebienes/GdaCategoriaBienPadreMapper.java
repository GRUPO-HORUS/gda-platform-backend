package com.horustek.gda.shared.mapper.gestiondebienes;

import com.horustek.gda.model.domain.GdaCategoriaBien;
import com.horustek.gda.shared.dto.gestionbienes.GdaCategoriaBienPadreDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper()
public interface GdaCategoriaBienPadreMapper {

    GdaCategoriaBienPadreDTO toGdaCategoriaBienPadreDTO(GdaCategoriaBien gdaCategoriaBien);
    List<GdaCategoriaBienPadreDTO> toGdaCategoriaBienPadreDTOs(List<GdaCategoriaBien> gdaCategoriaBiens);
}
