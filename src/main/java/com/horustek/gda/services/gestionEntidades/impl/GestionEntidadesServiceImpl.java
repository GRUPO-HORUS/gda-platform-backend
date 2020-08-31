package com.horustek.gda.services.gestionEntidades.impl;

import com.horustek.gda.infra.exceptions.BusinessException;
import com.horustek.gda.infra.exceptions.ErrorCodesEnum;
import com.horustek.gda.model.domain.GdaEntidad;
import com.horustek.gda.repositories.gestionEntidades.EntidadRepository;
import com.horustek.gda.services.gestionEntidades.IGestionEntidadesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GestionEntidadesServiceImpl implements IGestionEntidadesService {

    private final EntidadRepository entidadRepository;

    public GestionEntidadesServiceImpl(EntidadRepository entidadRepository) {
        this.entidadRepository = entidadRepository;
    }

    @Override
    public void crearEntidad(String nombre) {

        // Revisar si no existe una entidad con ese nombre en la Base de datos

        GdaEntidad nuevaEntidad = GdaEntidad.builder()
                .nombre(nombre).build();
        Boolean existe = entidadRepository.findByNombre(nuevaEntidad.getNombre());

        // Si no hay ninguna entidad , creo la primera
        if (existe == null || !existe) entidadRepository.save(nuevaEntidad);
        else throw new BusinessException(ErrorCodesEnum.GDA_ERR_06, nombre);
    }
}
