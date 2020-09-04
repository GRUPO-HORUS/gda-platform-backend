package com.horustek.gda.shared.mapper.gestiondebienes;

import com.horustek.gda.model.domain.GdaBien;
import com.horustek.gda.shared.dto.gestionbienes.GDABienDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper()
public interface GdaBienMapper {

    GDABienDTO toGdaBienDTO(GdaBien gdaBien);
    List<GDABienDTO> toGdaBienDTOs(List<GdaBien> gdaBiens);
}
