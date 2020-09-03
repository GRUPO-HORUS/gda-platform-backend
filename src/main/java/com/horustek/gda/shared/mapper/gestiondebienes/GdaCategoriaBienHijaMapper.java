package com.horustek.gda.shared.mapper.gestiondebienes;

import com.horustek.gda.model.domain.GdaCategoriaBien;
import com.horustek.gda.shared.dto.gestionbienes.GdaCategoriaBienHijaDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper()
public interface GdaCategoriaBienHijaMapper {

    GdaCategoriaBienHijaDTO toGdaCategoriaBienHijaDTO(GdaCategoriaBien gdaCategoriaBien);
    List<GdaCategoriaBienHijaDTO> toGdaCategoriaBienHijaDTOs(List<GdaCategoriaBien> gdaCategoriaBiens);
}
