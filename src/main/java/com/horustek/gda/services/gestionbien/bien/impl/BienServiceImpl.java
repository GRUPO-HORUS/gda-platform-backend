package com.horustek.gda.services.gestionbien.bien.impl;

import com.horustek.gda.model.domain.GdaBien;
import com.horustek.gda.model.domain.GdaBienTipo;
import com.horustek.gda.model.domain.GdaUsuario;
import com.horustek.gda.repositories.gestionbienes.BienRepository;
import com.horustek.gda.repositories.gestionbienes.BienTipoRepository;
import com.horustek.gda.services.gestionbien.bien.IBienService;
import com.horustek.gda.shared.dto.gestionbienes.GDABienDTO;
import com.horustek.gda.shared.dto.gestionbienes.GDABienTipoDTO;
import com.horustek.gda.shared.dto.seguridad.GdaUsuarioDTO;
import com.horustek.gda.shared.mapper.gestiondebienes.GdaBienMapper;
import com.horustek.gda.shared.mapper.gestiondebienes.GdaBienTipoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class BienServiceImpl implements IBienService {

    private final BienRepository bienRepository;
    private final BienTipoRepository bienTipoRepository;
    private final GdaBienMapper gdaBienMapper;
    private final GdaBienTipoMapper gdaBienTipoMapper;

    @Override
    public void crearBien() {

    }

    @Override
    public Page<GDABienDTO> findAll(Pageable pageable) {

        Page<GdaBien> bienDTOPage = bienRepository.findAll(pageable);
        List<GDABienDTO> list = gdaBienMapper
                .toGdaBienDTOs(bienDTOPage.getContent());
        return new PageImpl<>(list, pageable, bienDTOPage.getTotalElements());
    }

    @Override
    public Page<GDABienTipoDTO> findAllTiposBienes(Pageable pageable) {
        Page<GdaBienTipo> bienTipoDTOPage = bienTipoRepository.findAll(pageable);
        List<GDABienTipoDTO> list = gdaBienTipoMapper
                .toGdaBienTipoDTOs(bienTipoDTOPage.getContent());
        return new PageImpl<>(list, pageable, bienTipoDTOPage.getTotalElements());
    }
}
