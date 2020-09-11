package com.horustek.gda.services.gestionbien.bien.impl;

import com.horustek.gda.infra.exceptions.BusinessException;
import com.horustek.gda.infra.exceptions.ErrorCodesEnum;
import com.horustek.gda.model.domain.GdaCoeficienteRevaluo;
import com.horustek.gda.repositories.gestionbienes.CoeficienteDepreciacionRepository;
import com.horustek.gda.services.gestionbien.bien.IBienDatosContablesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Calendar;
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
        Optional<GdaCoeficienteRevaluo> optionalGdaCoeficienteDepreciacion = coeficienteDepreciacionRepository
                .findByAnno(actualYear);
        if (!optionalGdaCoeficienteDepreciacion.isPresent()) {
            // Si no existe registro para el año actual
            // Entonces procedemos a crear el mismo

            GdaCoeficienteRevaluo nuevoCoefeicienteDepreciacion = GdaCoeficienteRevaluo.builder()
                    .anno(actualYear)
                    .valor(valorCoeficiente)
                    .build();
            coeficienteDepreciacionRepository.save(nuevoCoefeicienteDepreciacion);

        } else {
            throw new BusinessException(ErrorCodesEnum.GDA_ERR_15);
        }

    }
}
