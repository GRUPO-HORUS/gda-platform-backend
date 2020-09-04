package com.horustek.gda.shared.mapper.gestiondebienes;

import com.horustek.gda.model.domain.GdaBien;
import com.horustek.gda.model.domain.GdaBienTipo;
import com.horustek.gda.shared.dto.gestionbienes.GDABienDTO;
import com.horustek.gda.shared.dto.gestionbienes.GDABienTipoDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper()
public interface GdaBienTipoMapper {

    GDABienTipoDTO toGdaBienTipoDTO(GdaBienTipo gdaBien);
    List<GDABienTipoDTO> toGdaBienTipoDTOs(List<GdaBienTipo> gdaBiens);
}
