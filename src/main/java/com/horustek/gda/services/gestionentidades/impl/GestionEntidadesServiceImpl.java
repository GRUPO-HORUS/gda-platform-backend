package com.horustek.gda.services.gestionentidades.impl;

import com.horustek.gda.infra.exceptions.BusinessException;
import com.horustek.gda.infra.exceptions.ErrorCodesEnum;
import com.horustek.gda.infra.model.BaseSpecification;
import com.horustek.gda.infra.model.SearchCriteria;
import com.horustek.gda.infra.model.SearchOperation;
import com.horustek.gda.model.domain.GdaEntidad;
import com.horustek.gda.model.domain.GdaTipoUnidad;
import com.horustek.gda.model.domain.GdaUnidad;
import com.horustek.gda.repositories.gestionentidades.EntidadRepository;
import com.horustek.gda.repositories.gestionentidades.TipoUnidadRepository;
import com.horustek.gda.repositories.gestionentidades.UnidadRepository;
import com.horustek.gda.services.gestionentidades.IGestionEntidadesService;
import com.horustek.gda.shared.dto.gestionEntidades.GdaTipoUnidadDTO;
import com.horustek.gda.shared.dto.gestionEntidades.GdaUnidadDTO;
import com.horustek.gda.shared.mapper.gestionentidades.GdaTipoUnidadMapper;
import com.horustek.gda.shared.mapper.gestionentidades.GdaUnidadMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class GestionEntidadesServiceImpl implements IGestionEntidadesService {

    private final EntidadRepository entidadRepository;
    private final TipoUnidadRepository tipoUnidadRepository;
    private final GdaTipoUnidadMapper gdaTipoUnidadMapper;
    private final GdaUnidadMapper gdaUnidadMapper;
    private final UnidadRepository unidadRepository;

    public GestionEntidadesServiceImpl(EntidadRepository entidadRepository, TipoUnidadRepository tipoUnidadRepository,
                                       GdaTipoUnidadMapper gdaTipoUnidadMapper, UnidadRepository unidadRepository,
                                       GdaUnidadMapper gdaUnidadMapper) {
        this.entidadRepository = entidadRepository;
        this.tipoUnidadRepository = tipoUnidadRepository;
        this.gdaTipoUnidadMapper = gdaTipoUnidadMapper;
        this.gdaUnidadMapper = gdaUnidadMapper;
        this.unidadRepository = unidadRepository;
    }

    @Override
    public void crearEntidad(String nombre) {

        // Revisar si no existe una entidad con ese nombre en la Base de datos

        Optional<GdaEntidad> optionalGdaEntidad = entidadRepository.findByNombre(nombre);
        if (!optionalGdaEntidad.isPresent()) {
            GdaEntidad nuevaEntidad = GdaEntidad.builder()
                    .nombre(nombre).build();
            entidadRepository.save(nuevaEntidad);
        } else throw new BusinessException(ErrorCodesEnum.GDA_ERR_06, nombre);
    }

    @Override
    public Page<GdaTipoUnidadDTO> listarTipoUnidades(Pageable pageable) {
        Page<GdaTipoUnidad> tipoUnidadPage = tipoUnidadRepository.findAll(pageable);
        List<GdaTipoUnidadDTO> list = gdaTipoUnidadMapper
                .toGdaTipoUnidadDTOs(tipoUnidadPage.getContent());
        return new PageImpl<>(list, pageable, tipoUnidadPage.getTotalElements());

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

    public List<GdaUnidadDTO> listadoUnidadesDadoNombreEntidad(String nombreEntidad) {

        Optional<GdaEntidad> optionalGdaEntidad = entidadRepository.findByNombre(nombreEntidad);

        if (optionalGdaEntidad.isPresent()) {
            GdaEntidad entidad = optionalGdaEntidad.get();

            BaseSpecification<GdaUnidad> specification = new BaseSpecification<>();
            specification.add(new SearchCriteria("gdaEntidadId", entidad, SearchOperation.EQUAL));
            List<GdaUnidad> unidadesDeEntidad = unidadRepository.findAll(specification);
            List<GdaUnidadDTO> unidadDTOS = gdaUnidadMapper.toGdaUnidadDTOs(unidadesDeEntidad);
            return unidadDTOS;
        }
        throw new BusinessException(ErrorCodesEnum.GDA_ERR_09, nombreEntidad);
    }

    @Override
    public void asignarUnidadPadreAListadoDeUnidades(GdaUnidadDTO unidadPadreDTO, List<GdaUnidadDTO> unidadesHijasDTO) {

        // Obtener todas las unidades hija de una entidad conocida
        Optional<GdaUnidad> optionlUnidadPadre = unidadRepository.findById(unidadPadreDTO.getId());
        if (optionlUnidadPadre.isPresent()) {
            GdaUnidad unidadPadre = optionlUnidadPadre.get();
            List<String> idsUnidadesHijas = unidadesHijasDTO.stream().map(GdaUnidadDTO::getId).collect(Collectors.toList());
            List<GdaUnidad> unidadesHijas = unidadRepository.findGdaUnidadByIdIn(idsUnidadesHijas);

            // Si ese padre tiene unidades hijas entonces voy a actualizar el valor del id de su unidad padre
            if (!unidadesHijas.isEmpty()) {
                unidadRepository.actualizarUnidadPadre(unidadPadre.getId(), unidadesHijas);
            }
        }
    }

    @Override
    @Transactional
    public void crearUnidad(GdaUnidadDTO unidadDTO) {
        if (unidadDTO.getGdaEntidadId() == null)
            throw new BusinessException(ErrorCodesEnum.GDA_ERR_08, unidadDTO.getNombre());

        Optional<GdaEntidad> optionalGdaEntidad = entidadRepository.findById(unidadDTO.getGdaEntidadId().getId());
        if (optionalGdaEntidad.isPresent()) {
            // Buscar en las unidades pertenecientes a la entidad de la unidad a crear si hay una con el mismo nombre
            List<GdaUnidadDTO> unidadesDeLaEntidad = listadoUnidadesDadoNombreEntidad(optionalGdaEntidad.get().getNombre());

            unidadesDeLaEntidad.stream().filter(dto -> dto.getNombre()
                    .equals(unidadDTO.getNombre())).forEach(dto -> {
                throw new BusinessException(ErrorCodesEnum.GDA_ERR_10, optionalGdaEntidad.get().getNombre(), unidadDTO.getNombre());
            });

            //Comprobar si el tipo de unidad existe
            Optional<GdaTipoUnidad> optionalTipoUnidad = tipoUnidadRepository.findById(unidadDTO.getGdaTipoUnidadId().getId());
            if (!optionalTipoUnidad.isPresent()) {
                throw new BusinessException(ErrorCodesEnum.GDA_ERR_11);
            }

            // Creo la nueva  unidad en la base de datos
            GdaUnidad nuevaUnidad = GdaUnidad.builder()
                    .nombre(unidadDTO.getNombre())
                    .gdaEntidadId(optionalGdaEntidad.get())
                    .gdaTipoUnidadId(optionalTipoUnidad.get()).build();
            unidadRepository.save(nuevaUnidad);

            // Verificar si en el momento de creación se le asignó una lista de unidades hijas de la cual esta es padre
            if (unidadDTO.getGdaUnidadList() != null && !unidadDTO.getGdaUnidadList().isEmpty()) {
                // Si este listado no esta vacío es que esta unidad es padre de otra/s unidad/es
                asignarUnidadPadreAListadoDeUnidades(unidadDTO, unidadDTO.getGdaUnidadList());
            }
        }


    }
}