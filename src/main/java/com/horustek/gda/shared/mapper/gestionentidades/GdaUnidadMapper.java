package com.horustek.gda.shared.mapper.gestionentidades;

import com.horustek.gda.model.domain.GdaUnidad;
import com.horustek.gda.shared.dto.gestionEntidades.GdaUnidadRequestDTO;
import com.horustek.gda.shared.dto.gestionEntidades.GdaUnidadHijaDTO;
import com.horustek.gda.shared.dto.gestionEntidades.GdaUnidadPadreDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper()
public interface GdaUnidadMapper {

    GdaUnidadRequestDTO toGdaUnidadDTO(GdaUnidad gdaUnidad);

    List<GdaUnidadRequestDTO> toGdaUnidadDTOs(List<GdaUnidad> gdaUnidades);

    GdaUnidadPadreDTO toGdaUnidadPadreDTO(GdaUnidad gdaUnidad);

    List<GdaUnidadPadreDTO> toGdaUnidadPadreDTOs(List<GdaUnidad> gdaUnidades);

    GdaUnidadHijaDTO toGdaUnidadHijaDTO(GdaUnidad gdaUnidad);

    List<GdaUnidadHijaDTO> toGdaUnidadHijaDTOs(List<GdaUnidad> gdaUnidades);
}
