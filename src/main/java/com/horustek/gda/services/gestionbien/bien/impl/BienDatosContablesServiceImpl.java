package com.horustek.gda.services.gestionbien.bien.impl;

import com.horustek.gda.infra.exceptions.BusinessException;
import com.horustek.gda.infra.exceptions.ErrorCodesEnum;
import com.horustek.gda.infra.model.BaseSpecification;
import com.horustek.gda.infra.model.SearchCriteria;
import com.horustek.gda.infra.model.SearchOperation;
import com.horustek.gda.model.domain.GdaBien;
import com.horustek.gda.model.domain.GdaBienFijoDatos;
import com.horustek.gda.model.domain.GdaBienTipo;
import com.horustek.gda.model.domain.GdaCoeficienteDepreciacion;
import com.horustek.gda.repositories.gestionbienes.BienFijoDatosRepository;
import com.horustek.gda.repositories.gestionbienes.BienRepository;
import com.horustek.gda.repositories.gestionbienes.BienTipoRepository;
import com.horustek.gda.repositories.gestionbienes.CoeficienteDepreciacionRepository;
import com.horustek.gda.services.gestionbien.bien.IBienDatosContablesService;
import com.horustek.gda.services.gestionbien.bien.IBienService;
import com.horustek.gda.shared.dto.gestionbienes.*;
import com.horustek.gda.shared.mapper.gestiondebienes.GdaBienMapper;
import com.horustek.gda.shared.mapper.gestiondebienes.GdaBienTipoMapper;
import jdk.nashorn.internal.runtime.options.Option;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class BienDatosContablesServiceImpl implements IBienDatosContablesService {

    private final CoeficienteDepreciacionRepository coeficienteDepreciacionRepository;


    @Override
    public void insertarCoeficienteRevaluo(double valorCoeficiente) {

        int actualYear = Calendar.getInstance().get(Calendar.YEAR);

        // Revisar que para el año no exista un coeficiente de revaluo
        Optional<GdaCoeficienteDepreciacion> optionalGdaCoeficienteDepreciacion = coeficienteDepreciacionRepository
                .findByAnno(actualYear);
        if (!optionalGdaCoeficienteDepreciacion.isPresent()) {
            // Si no existe registro para el año actual
            // Entonces procedemos a crear el mismo

            GdaCoeficienteDepreciacion nuevoCoefeicienteDepreciacion = GdaCoeficienteDepreciacion.builder()
                    .anno(actualYear)
                    .valor(valorCoeficiente)
                    .build();
            coeficienteDepreciacionRepository.save(nuevoCoefeicienteDepreciacion);

        } else {
            throw new BusinessException(ErrorCodesEnum.GDA_ERR_15);
        }

    }
}
