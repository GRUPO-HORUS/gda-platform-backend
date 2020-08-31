package com.horustek.gda.services.gestionEntidades.impl;

import com.horustek.gda.infra.exceptions.BusinessException;
import com.horustek.gda.infra.exceptions.ErrorCodesEnum;
import com.horustek.gda.model.domain.GdaEntidad;
import com.horustek.gda.model.domain.GdaTipoUnidad;
import com.horustek.gda.repositories.gestionEntidades.EntidadRepository;
import com.horustek.gda.repositories.gestionEntidades.TipoUnidadRepository;
import com.horustek.gda.services.gestionEntidades.IGestionEntidadesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GestionEntidadesServiceImpl implements IGestionEntidadesService {

    private final EntidadRepository entidadRepository;
    private final TipoUnidadRepository tipoUnidadRepository;

    public GestionEntidadesServiceImpl(EntidadRepository entidadRepository, TipoUnidadRepository tipoUnidadRepository) {
        this.entidadRepository = entidadRepository;
        this.tipoUnidadRepository = tipoUnidadRepository;
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

    @Override
    public void crearTipoUnidad(String descripcion) {

        // Revisar si no existe tipo de Entidad con ese nombre en la Base de datos

        GdaTipoUnidad nuevoTipoUnidad = GdaTipoUnidad.builder()
                .descripcion(descripcion.toUpperCase()).build();
        Boolean existe = tipoUnidadRepository.findByDescripcionIgnoreCase(nuevoTipoUnidad.getDescripcion());

        // Si no hay tipos de entidades creados , creo la primera
        if (existe == null || !existe) tipoUnidadRepository.save(nuevoTipoUnidad);
        else throw new BusinessException(ErrorCodesEnum.GDA_ERR_07, descripcion);
    }
}
