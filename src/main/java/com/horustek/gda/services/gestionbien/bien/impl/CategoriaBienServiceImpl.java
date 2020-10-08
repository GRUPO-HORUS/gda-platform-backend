package com.horustek.gda.services.gestionbien.bien.impl;

import com.horustek.gda.infra.exceptions.BusinessException;
import com.horustek.gda.infra.exceptions.ErrorCodesEnum;
import com.horustek.gda.infra.model.BaseSpecification;
import com.horustek.gda.infra.model.SearchCriteria;
import com.horustek.gda.infra.model.SearchOperation;
import com.horustek.gda.model.domain.GdaAtributoCategoriaBien;
import com.horustek.gda.model.domain.GdaBien;
import com.horustek.gda.model.domain.GdaBienFijoDatos;
import com.horustek.gda.model.domain.GdaCategoriaBien;
import com.horustek.gda.repositories.gestionbienes.AtributoCategoriaBienRepository;
import com.horustek.gda.repositories.gestionbienes.BienFijoDatosRepository;
import com.horustek.gda.repositories.gestionbienes.CategoriaRepository;
import com.horustek.gda.services.gestionbien.bien.ICategoriaBienService;
import com.horustek.gda.shared.dto.gestionbienes.*;
import com.horustek.gda.shared.mapper.gestiondebienes.GdaCategoriaBienHijaMapper;
import com.horustek.gda.shared.mapper.gestiondebienes.GdaCategoriaBienMapper;
import com.horustek.gda.shared.mapper.gestiondebienes.GdaCategoriaBienPadreMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoriaBienServiceImpl implements ICategoriaBienService {

    private final CategoriaRepository categoriaRepository;
    private final AtributoCategoriaBienRepository atributoCategoriaBienRepository;
    private final GdaCategoriaBienPadreMapper gdaCategoriaBienPadreMapper;
    private final GdaCategoriaBienMapper gdaCategoriaBienMapper;
    private final GdaCategoriaBienHijaMapper gdaCategoriaBienHijaMapper;
    private final BienFijoDatosRepository bienFijoDatosRepository;


    @Override
    public Page<GdaCategoriaBienDTO> findAll(Pageable pageable) {

        Page<GdaCategoriaBien> categoriaBienPage = categoriaRepository.findAll(pageable);
        List<GdaCategoriaBienDTO> list = gdaCategoriaBienMapper
                .toGdaCategoriaBienDTOs(categoriaBienPage.getContent());
        return new PageImpl<>(list, pageable, categoriaBienPage.getTotalElements());
    }

    @Override
    public Page<GdaCategoriaBienPadreDTO> getCategoriaBase(Pageable pageable) {

        Page<GdaCategoriaBien> categoriaBienPage = categoriaRepository.findCategoriaBase(pageable);
        List<GdaCategoriaBienPadreDTO> list = gdaCategoriaBienPadreMapper
                .toGdaCategoriaBienPadreDTOs(categoriaBienPage.getContent());
        return new PageImpl<>(list, pageable, categoriaBienPage.getTotalElements());
    }

    @Override
    public Page<GdaCategoriaBienHijaDTO> getCategoriasHijas(String idCategoriaPadre, Pageable pageable) {

        Optional<GdaCategoriaBien> categoriaBienPadre = categoriaRepository.findById(idCategoriaPadre);

        if (categoriaBienPadre.isPresent()) {

            Page<GdaCategoriaBien> categoriaBienPage = categoriaRepository
                    .findAllByGdaCategoriaBienId(categoriaBienPadre.get(), pageable);

            List<GdaCategoriaBienHijaDTO> list = gdaCategoriaBienHijaMapper
                    .toGdaCategoriaBienHijaDTOs(categoriaBienPage.getContent());
            return new PageImpl<>(list, pageable, categoriaBienPage.getTotalElements());

        }

        Page<GdaCategoriaBien> categoriaBienPage = categoriaRepository.findCategoriaBase(pageable);
        List<GdaCategoriaBienHijaDTO> list = gdaCategoriaBienHijaMapper
                .toGdaCategoriaBienHijaDTOs(categoriaBienPage.getContent());
        return new PageImpl<>(list, pageable, categoriaBienPage.getTotalElements());
    }

    @Override
    public GdaDetalleAtributoCategoriaFormDTO obtenerLisobtenerListadoAtributosFormCategoria(String idCategoria) {

        Optional<GdaCategoriaBien> optionalGdaCategoriaBien = categoriaRepository.findById(idCategoria);
        List<AtributoFormularioBienDTO> dtos = new ArrayList<>();
        if (optionalGdaCategoriaBien.isPresent()) {
            List<GdaAtributoCategoriaBien> atributosCategoriaBien = atributoCategoriaBienRepository
                    .findByGdaCategoriaBienId(optionalGdaCategoriaBien.get());

            for (GdaAtributoCategoriaBien atributo : atributosCategoriaBien) {
                AtributoFormularioBienDTO atributoFormularioBienDTO = AtributoFormularioBienDTO.builder()
                        .id(atributo.getId())
                        .nombre(atributo.getNombre())
                        .unico(atributo.isUnico())
                        .tipoDatoAtributos(atributo.getTipoDatoAtributos())
                        .requerido(atributo.isRequerido()).build();
                dtos.add(atributoFormularioBienDTO);
            }

        } else {
            throw new BusinessException(ErrorCodesEnum.GDA_ERR_18);
        }

        return GdaDetalleAtributoCategoriaFormDTO.builder()
                .atributoFormularioBien(dtos).build();
    }

    @Override
    @Transactional
    public void insertarAtributosDinamicos(List<AtributoFormularioBienRequestDTO> atributosDinamicos, GdaBien bien) {


        for (AtributoFormularioBienRequestDTO dto : atributosDinamicos) {


            GdaBienFijoDatos gdaBienFijoDatos = GdaBienFijoDatos.builder()
                    .gdaBienFijoId(bien)
                    .gdaAtributoCategoriaBienId(GdaAtributoCategoriaBien.builder().id(dto.getIdAtributoCategoriaBien()).build())
                    .valor(dto.getValor()).build();

            bienFijoDatosRepository.save(gdaBienFijoDatos);
        }


    }
}