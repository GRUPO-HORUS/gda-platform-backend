package com.horustek.gda.shared.mapper.gestionentidades;

import com.horustek.gda.model.domain.GdaUnidad;
import com.horustek.gda.shared.dto.gestionEntidades.GdaUnidadBienResponseDTO;
import com.horustek.gda.shared.dto.gestionEntidades.GdaUnidadHijaDTO;
import com.horustek.gda.shared.dto.gestionEntidades.GdaUnidadPadreDTO;
import com.horustek.gda.shared.dto.gestionEntidades.GdaUnidadRequestDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper()
public interface GdaUnidadResponseMapper {

    GdaUnidadBienResponseDTO toGdaUnidadDTO(GdaUnidad gdaUnidad);

    List<GdaUnidadBienResponseDTO> toGdaUnidadDTOs(List<GdaUnidad> gdaUnidades);


}
