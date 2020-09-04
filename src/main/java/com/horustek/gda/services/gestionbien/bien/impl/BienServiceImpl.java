package com.horustek.gda.services.gestionbien.bien.impl;

import com.horustek.gda.infra.exceptions.BusinessException;
import com.horustek.gda.infra.exceptions.ErrorCodesEnum;
import com.horustek.gda.infra.model.BaseSpecification;
import com.horustek.gda.infra.model.SearchCriteria;
import com.horustek.gda.infra.model.SearchOperation;
import com.horustek.gda.model.domain.*;
import com.horustek.gda.repositories.gestionbienes.BienFijoDatosRepository;
import com.horustek.gda.repositories.gestionbienes.BienRepository;
import com.horustek.gda.repositories.gestionbienes.BienTipoRepository;
import com.horustek.gda.services.gestionbien.bien.IBienService;
import com.horustek.gda.shared.dto.gestionbienes.*;
import com.horustek.gda.shared.mapper.gestiondebienes.GdaBienMapper;
import com.horustek.gda.shared.mapper.gestiondebienes.GdaBienTipoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class BienServiceImpl implements IBienService {

    private final BienRepository bienRepository;
    private final BienFijoDatosRepository bienFijoDatosRepository;
    private final BienTipoRepository bienTipoRepository;
    private final GdaBienMapper gdaBienMapper;
    private final GdaBienTipoMapper gdaBienTipoMapper;


    @Override
    public void crearBien(RegistroBienDTO registroBienDTO) {


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

    @Override
    public GdaDetalleBienDTO obtenerListadoAtributosBien(String idBien) {


        Optional<GdaBien> gdaBien = bienRepository.findById(idBien);
        if (gdaBien.isPresent()) {

            BaseSpecification<GdaBienFijoDatos> specification = new BaseSpecification<>();
            specification.add(new SearchCriteria("gdaBienFijoId", gdaBien.get(), SearchOperation.EQUAL));
            List<GdaBienFijoDatos> bienFijoDatos = bienFijoDatosRepository.findAll(specification);

            List<AtributoValorBienDTO> atributoValorBienDTOS = new ArrayList<>();

            for (GdaBienFijoDatos datos : bienFijoDatos) {
                AtributoValorBienDTO atributoValorBienDTO = AtributoValorBienDTO.builder()
                        .atributo(datos.getGdaAtributoCategoriaBienId().getNombre())
                        .valor(datos.getValor()).build();
                atributoValorBienDTOS.add(atributoValorBienDTO);
            }

            return GdaDetalleBienDTO.builder()
                    .atributoValorBienDTOS(atributoValorBienDTOS).build();
        }
        throw new BusinessException(ErrorCodesEnum.GDA_ERR_14);
    }
}
