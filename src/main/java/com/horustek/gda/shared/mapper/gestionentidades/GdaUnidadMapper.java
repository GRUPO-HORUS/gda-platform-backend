package com.horustek.gda.shared.mapper.gestionentidades;

import com.horustek.gda.model.domain.GdaUnidad;
import com.horustek.gda.shared.dto.gestionEntidades.GdaUnidadDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper()
public interface GdaUnidadMapper {

    GdaUnidadDTO toGdaUnidadDTO(GdaUnidad gdaUnidad);
    List<GdaUnidadDTO> toGdaUnidadDTOs(List<GdaUnidad> gdaUnidades);
}
