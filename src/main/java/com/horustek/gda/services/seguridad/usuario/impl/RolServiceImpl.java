package com.horustek.gda.services.seguridad.usuario.impl;

import com.horustek.gda.model.domain.GdaRol;
import com.horustek.gda.repositories.seguridad.RolRepository;
import com.horustek.gda.services.seguridad.usuario.IRolService;
import com.horustek.gda.shared.dto.seguridad.GdaRolDTO;
import com.horustek.gda.shared.dto.seguridad.GdaUsuarioDTO;
import com.horustek.gda.shared.mapper.GdaRolMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class RolServiceImpl implements IRolService {

    private final RolRepository rolRepository;
    private final GdaRolMapper gdaRolMapper;

    public RolServiceImpl(RolRepository rolRepository, GdaRolMapper gdaRolMapper) {
        this.rolRepository = rolRepository;
        this.gdaRolMapper = gdaRolMapper;
    }

    @Override
    public Page<GdaRolDTO> findAll(Pageable pageable) {
        Page<GdaRol> rolPage = rolRepository.findAll(pageable);
        List<GdaRolDTO> list = gdaRolMapper
                .toGdaRolDTOs(rolPage.getContent());
        return new PageImpl<>(list, pageable, rolPage.getTotalElements());
    }
}

