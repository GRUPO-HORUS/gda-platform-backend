package com.horustek.gda.shared.mapper.gestiondebienes;

import com.horustek.gda.model.domain.GdaBienAsignaciones;
import com.horustek.gda.shared.dto.gestionbienes.GDABienAsignacionDTO;
import com.horustek.gda.shared.dto.gestionbienes.GDABienAsignacionResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper()
public interface GdaBienAsignacionResponseMapper {

    @Mapping(target="gdaUsuarioId.roles", ignore=true)
    GDABienAsignacionResponseDTO toGdaBienAsignacionResponseDTO(GdaBienAsignaciones gdaBienAsignaciones);

    List<GDABienAsignacionResponseDTO> toGdaBienAsignacionResponseDTOs(List<GdaBienAsignaciones> gdaBienAsignaciones);
}
