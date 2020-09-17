package com.horustek.gda.services.gestionbien.bien.impl;

import com.horustek.gda.model.domain.GdaCategoriaBien;
import com.horustek.gda.repositories.gestionbienes.CategoriaRepository;
import com.horustek.gda.services.gestionbien.bien.ICategoriaBienService;
import com.horustek.gda.shared.dto.gestionbienes.GdaCategoriaBienDTO;
import com.horustek.gda.shared.dto.gestionbienes.GdaCategoriaBienHijaDTO;
import com.horustek.gda.shared.dto.gestionbienes.GdaCategoriaBienPadreDTO;
import com.horustek.gda.shared.mapper.gestiondebienes.GdaCategoriaBienHijaMapper;
import com.horustek.gda.shared.mapper.gestiondebienes.GdaCategoriaBienMapper;
import com.horustek.gda.shared.mapper.gestiondebienes.GdaCategoriaBienPadreMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaBienServiceImpl implements ICategoriaBienService {

    private final CategoriaRepository categoriaRepository;
    private final GdaCategoriaBienPadreMapper gdaCategoriaBienPadreMapper;
    private final GdaCategoriaBienMapper gdaCategoriaBienMapper;
    private final GdaCategoriaBienHijaMapper gdaCategoriaBienHijaMapper;

    public CategoriaBienServiceImpl(CategoriaRepository categoriaRepository, GdaCategoriaBienPadreMapper gdaCategoriaBienPadreMapper,
                                    GdaCategoriaBienMapper gdaCategoriaBienMapper,
                                    GdaCategoriaBienHijaMapper gdaCategoriaBienHijaMapper) {
        this.categoriaRepository = categoriaRepository;
        this.gdaCategoriaBienPadreMapper = gdaCategoriaBienPadreMapper;
        this.gdaCategoriaBienMapper = gdaCategoriaBienMapper;
        this.gdaCategoriaBienHijaMapper = gdaCategoriaBienHijaMapper;
    }


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
}
