package com.horustek.gda.shared.mapper.gestionentidades;

import com.horustek.gda.model.domain.GdaTipoUnidad;
import com.horustek.gda.shared.dto.gestionEntidades.GdaTipoUnidadDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper()
public interface GdaTipoUnidadMapper {

    GdaTipoUnidadDTO toGdaTipoUnidadDTO(GdaTipoUnidad GdaTipoUnidad);
    List<GdaTipoUnidadDTO> toGdaTipoUnidadDTOs(List<GdaTipoUnidad> GdaTipoUnidades);
}
