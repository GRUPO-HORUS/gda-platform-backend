package com.horustek.gda.services.gestionalertas.impl;

import com.horustek.gda.infra.exceptions.BusinessException;
import com.horustek.gda.infra.exceptions.ErrorCodesEnum;
import com.horustek.gda.model.domain.GdaBien;
import com.horustek.gda.model.domain.GdaBienTraza;
import com.horustek.gda.repositories.gestionbienes.BienRepository;
import com.horustek.gda.repositories.gestionbienes.BienTrazaRepository;
import com.horustek.gda.services.gestionalertas.IBienTrazaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class BienTrazaServiceImpl implements IBienTrazaService {
    private final BienTrazaRepository bienTrazaRepository;
    private final BienRepository bienRepository;

    @Override
    @Transactional
    public void eventoCreacion(GdaBien bien) {

        String detalle = String.format("El bien con rótulo %s fue creado", bien.getRotulado());

        GdaBienTraza nuevaTraza = GdaBienTraza.builder()
                .detalle(detalle)
                .fechaEvento(new Date())
                .gdaBienId(bien).build();
        bienTrazaRepository.save(nuevaTraza);

    }


    @Override
    public Page<GdaBienTraza> findAll(String rotuladoId, Pageable pageable) {

        Optional<GdaBien> bien = bienRepository.findByRotulado(rotuladoId);

        if (bien.isPresent()) {
            Page<GdaBienTraza> listadoTrazasDeUnBien = bienTrazaRepository.findAllByGdaBienId(bien.get(), pageable);
            return new PageImpl<>(listadoTrazasDeUnBien.toList(), pageable, listadoTrazasDeUnBien.getTotalElements());
        }
        throw new BusinessException(ErrorCodesEnum.GDA_ERR_14);

    }
}
