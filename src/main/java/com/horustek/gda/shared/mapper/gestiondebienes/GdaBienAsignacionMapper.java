package com.horustek.gda.shared.mapper.gestiondebienes;

import com.horustek.gda.model.domain.GdaBien;
import com.horustek.gda.model.domain.GdaBienAsignaciones;
import com.horustek.gda.shared.dto.gestionbienes.GDABienAsignacionDTO;
import com.horustek.gda.shared.dto.gestionbienes.GDABienDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper()
public interface GdaBienAsignacionMapper {

    GDABienAsignacionDTO toGdaBienAsignacionDTO(GdaBienAsignaciones gdaBienAsignaciones);
    List<GDABienAsignacionDTO> toGdaBienAsignacionDTOs(List<GdaBienAsignaciones> gdaBienAsignaciones);
}
