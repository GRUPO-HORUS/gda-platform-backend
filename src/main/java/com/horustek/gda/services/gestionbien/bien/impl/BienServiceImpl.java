package com.horustek.gda.services.gestionbien.bien.impl;

import com.horustek.gda.infra.exceptions.BusinessException;
import com.horustek.gda.infra.exceptions.ErrorCodesEnum;
import com.horustek.gda.infra.model.BaseSpecification;
import com.horustek.gda.infra.model.SearchCriteria;
import com.horustek.gda.infra.model.SearchOperation;
import com.horustek.gda.infra.utils.NumberUtils;
import com.horustek.gda.model.domain.*;
import com.horustek.gda.model.domain.enumeradores.BienEstadoEnum;
import com.horustek.gda.model.domain.enumeradores.BienTipoAsignacionEnum;
import com.horustek.gda.model.domain.enumeradores.EstadoInactividadEnum;
import com.horustek.gda.repositories.gestionbienes.*;
import com.horustek.gda.repositories.gestionentidades.UnidadRepository;
import com.horustek.gda.repositories.seguridad.UsuarioRepository;
import com.horustek.gda.services.gestionbien.bien.IBienService;
import com.horustek.gda.services.gestionalertas.IBienTrazaService;
import com.horustek.gda.services.gestionbien.bien.ICategoriaBienService;
import com.horustek.gda.shared.dto.gestionbienes.*;
import com.horustek.gda.shared.mapper.gestiondebienes.GdaBienAsignacionMapper;
import com.horustek.gda.shared.mapper.gestiondebienes.GdaBienAsignacionResponseMapper;
import com.horustek.gda.shared.mapper.gestiondebienes.GdaBienMapper;
import com.horustek.gda.shared.mapper.gestiondebienes.GdaBienTipoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class BienServiceImpl implements IBienService {

    private final BienRepository bienRepository;
    private final UsuarioRepository usuarioRepository;
    private final CategoriaRepository bienCategoriaRepository;
    private final BienAsignacionesRepository asignacionesRepository;
    private final UnidadRepository unidadRepository;
    private final BienFijoDatosRepository bienFijoDatosRepository;
    private final BienTipoRepository bienTipoRepository;
    private final GdaBienMapper gdaBienMapper;
    private final GdaBienAsignacionResponseMapper gdaBienAsignacionResponseMapper;
    private final GdaBienTipoMapper gdaBienTipoMapper;
    private final IBienTrazaService traza;
    private final ICategoriaBienService categoriaBienService;


    @Override
    @Transactional
    public void crearBien(RegistroBienDTO registroBienDTO) {

        //TODO aca se necesita implementar la parte dinámica de los bienes


        // Por defecto un bien siempre comienza con el estado pendiente de etiquetado
        BienEstadoEnum bienEstadoEnum = BienEstadoEnum.PENDIENTE_ETIQUETADO;

        // Si a la hora de la creación se le especifica la ubicación entonces hay que asignar el bien a esta ubicación
        GdaUnidad unidadDelBien = null;
        if (registroBienDTO.getUnidadUbicacionId() != null)
            unidadDelBien = unidadRepository.getOne(registroBienDTO.getUnidadUbicacionId());

        // Tipo del Bien
        GdaBienTipo gdaBienTipo = null;
        if (registroBienDTO.getTipoBienId() != null)
            gdaBienTipo = bienTipoRepository.getOne(registroBienDTO.getTipoBienId());

        // Categoría del Bien
        GdaCategoriaBien gdaCategoriaBien = null;
        if (registroBienDTO.getCategoriaBienId() != null)
            gdaCategoriaBien = bienCategoriaRepository.getOne(registroBienDTO.getCategoriaBienId());


        // Crear el rotulo del bien
        String rotulado = crearRotuloBien();


        // Salvar los bienes padres
        GdaBien nuevoBien = GdaBien.builder()
                .bienEstadoConservacion(registroBienDTO.getEstadoConservacion())
                .detalle(registroBienDTO.getDetalle())
                .existenciaInventario(registroBienDTO.getExistenciaInventario())
                .gdaBienTipo(gdaBienTipo)
                .gdaCategoriaBienId(gdaCategoriaBien)
                .gdaUnidadUbicacionId(unidadDelBien)
                .valorIncorporacion(registroBienDTO.getValorIncorporacion())
                .bienEstado(bienEstadoEnum)
                .fechaIncorporacion(new Date())
                .rotulado(rotulado)
                .build();

        // Salvar el bien


        //Salvar los atributos dinámicos
        categoriaBienService.insertarAtributosDinamicos(registroBienDTO.getAtributosDinamicos(), nuevoBien);


        // Salvar las asignaciones RESPONSABLE,ASIGNADO,APROBADOR,CONTROL, REGISTRO
        // Todos las asignaciones por defectos son ACTIVAS


        // RESPONSABLE

        if (registroBienDTO.getUsuarioResponsableId() != null) {
            GDABienAsignacionDTO asignacionUsuarioResponsable = GDABienAsignacionDTO.builder()
                    .estado(EstadoInactividadEnum.ACTIVO)
                    .idBien(nuevoBien.getId())
                    .idUsuario(registroBienDTO.getUsuarioResponsableId())
                    .build();
            asignarResponsabilidades(asignacionUsuarioResponsable);

        }

        //ASIGNADO

        if (registroBienDTO.getUsuarioAsignadoId() != null) {
            GDABienAsignacionDTO asignacionUsuarioAsignado = GDABienAsignacionDTO.builder()
                    .estado(EstadoInactividadEnum.ACTIVO)
                    .idBien(nuevoBien.getId())
                    .idUsuario(registroBienDTO.getUsuarioAsignadoId())
                    .build();
            asignarResponsabilidades(asignacionUsuarioAsignado);

        }

        // APROBADOR

        if (registroBienDTO.getUsuarioAprobadorId() != null) {
            GDABienAsignacionDTO asignacionUsuarioAprobador = GDABienAsignacionDTO.builder()
                    .estado(EstadoInactividadEnum.ACTIVO)
                    .idBien(nuevoBien.getId())
                    .idUsuario(registroBienDTO.getUsuarioAprobadorId())
                    .build();
            asignarResponsabilidades(asignacionUsuarioAprobador);

        }

        // CONTROL

        if (registroBienDTO.getUsuarioControlId() != null) {
            GDABienAsignacionDTO asignacionUsuarioAprobador = GDABienAsignacionDTO.builder()
                    .estado(EstadoInactividadEnum.ACTIVO)
                    .idBien(nuevoBien.getId())
                    .idUsuario(registroBienDTO.getUsuarioControlId())
                    .build();
            asignarResponsabilidades(asignacionUsuarioAprobador);

        }


        // REGISTRO

        if (registroBienDTO.getUsuarioRegistroId() != null) {
            GDABienAsignacionDTO asignacionUsuarioRegistro = GDABienAsignacionDTO.builder()
                    .estado(EstadoInactividadEnum.ACTIVO)
                    .idBien(nuevoBien.getId())
                    .idUsuario(registroBienDTO.getUsuarioRegistroId())
                    .build();
            asignarResponsabilidades(asignacionUsuarioRegistro);

        }


        // TODO la traza hay que trabajarla con aspectos , pero por ahora esta con una clase utilitaria
        traza.eventoCreacion(nuevoBien);

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

    @Override
    public String crearRotuloBien() {

        // El # del Rótulo se compone de la siguiente manera: AA-BB-CC-DD


        List<GdaBien> bienList = bienRepository.findByRotuladoIsNotNullOrderByFechaCreacionDesc();
        GdaBien lastBien = bienList.get(0);
        String ultimoRotulado = lastBien.getRotulado();
        String[] parts = ultimoRotulado.split("-");
        int numeroBien = Integer.parseInt(parts[parts.length - 1]);

        int numberDigits = NumberUtils.NumberOfDigits(numeroBien);
        StringBuilder cerosACompletar = new StringBuilder();
        for (int i = 0; i < 5 - numberDigits; i++) {
            cerosACompletar.append("0");
        }

        return String.format("%s-%s-%s", "0000", "0001", cerosACompletar + String.valueOf(numeroBien));

    }

    @Override
    public void asignarResponsabilidades(GDABienAsignacionDTO dto) {

        GdaBien bien = null;
        GdaUsuario usuario = null;

        Optional<GdaBien> optionalGdaBien = bienRepository.findById(dto.getIdBien());
        Optional<GdaUsuario> optionalGdaUsuario = usuarioRepository.findById(dto.getIdUsuario());
        if (optionalGdaBien.isPresent()) {
            bien = optionalGdaBien.get();
            if (optionalGdaUsuario.isPresent()) {
                usuario = optionalGdaUsuario.get();

                // 1- Buscar si para el bien al que se le quiere hacer la asignacion
                // ya hay un usuario asignado con la
                // responsabilidad solicitada y el estado activo

                List<GdaBienAsignaciones> asignacionesDelBien = asignacionesRepository
                        .findByGdaBienIdAndGdaUsuarioIdAndTipoAsignacionAndEstado(
                                bien,
                                usuario,
                                dto.getTipoAsignacion(), dto.getEstado()
                        );

                // Si el resultado devuelve un valor entonces cambiamos el usuario antiguo por este nuevo
                // En caso que no se encuentre nada creamos una nueva asigancion
                if (!asignacionesDelBien.isEmpty()) {
                    GdaBienAsignaciones asignacionExistente = asignacionesDelBien.get(0);
                    // En caso de que el usuario que se quiera asignar es el mismo que existe, dejamos todo como está
                    if (!asignacionExistente.getGdaUsuarioId().equals(usuario)) {
                        asignacionExistente.setGdaUsuarioId(usuario);
                        asignacionesRepository.save(asignacionExistente);
                    }

                } else {

                    // Como el resultado es vacío creamos una nueva asignación para ese bien

                    GdaBienAsignaciones nuevaAsignacion = GdaBienAsignaciones.builder()
                            .gdaUsuarioId(usuario)
                            .gdaBienId(bien)
                            .tipoAsignacion(dto.getTipoAsignacion())
                            .estado(dto.getEstado())
                            .build();

                    asignacionesRepository.save(nuevaAsignacion);
                }


            } else {
                // No existe ese usuario en el sistema
                throw new BusinessException(ErrorCodesEnum.GDA_ERR_17);
            }

        } else {
            throw new BusinessException(ErrorCodesEnum.GDA_ERR_14);
        }


    }

    @Override
    public Page<GDABienAsignacionResponseDTO> listadoAsignacionesDeUnBien(String idBien, Pageable pageable) {

        if (idBien != null && !idBien.trim().isEmpty()) {
            Optional<GdaBien> optionalGdaBien = bienRepository.findById(idBien);
            if (optionalGdaBien.isPresent()) {
                Page<GdaBienAsignaciones> asignaciones = asignacionesRepository.findByGdaBienId(optionalGdaBien.get(), pageable);

                List<GDABienAsignacionResponseDTO> list = gdaBienAsignacionResponseMapper
                        .toGdaBienAsignacionResponseDTOs(asignaciones.getContent());
                return new PageImpl<>(list, pageable, asignaciones.getTotalElements());

            } else {
                throw new BusinessException(ErrorCodesEnum.GDA_ERR_14);
            }
        }

        return null;
    }


}
