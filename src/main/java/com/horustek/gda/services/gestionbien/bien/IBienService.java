package com.horustek.gda.services.gestionbien.bien;

import com.horustek.gda.model.domain.GdaBienAsignaciones;
import com.horustek.gda.model.domain.GdaUnidad;
import com.horustek.gda.shared.dto.gestionbienes.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBienService {

    void crearBien(RegistroBienDTO registroBienDTO);

    /**
     * Obtener todos los Bienes  del sistema
     *
     * @param pageable : Configuration de paginación
     * @return Listado paginado de todos los bienes
     */
    Page<GDABienDTO> findAll(Pageable pageable);

    /**
     * Obtener todos los Tipos de Bienes  del sistema
     *
     * @param pageable : Configuration de paginación
     * @return Listado paginado de todos los tipos de bienes
     */
    Page<GDABienTipoDTO> findAllTiposBienes(Pageable pageable);

    /**
     * Obtener listado de detalle de los atributos de un bien y sus valores
     * @param idBien Identificador del bien del cual se desea conocer sus valores
     * @return Objeto DTO con el detalle
     */
    GdaDetalleBienDTO obtenerListadoAtributosBien(String idBien);

    /**
     * Método utilizado para crear el rotulo de un bien
     * @return el número
     */
    String crearRotuloBien(GdaUnidad unidad);

    /**
     * Realizar una asignación de responsabilidad a un bien
     * @param dto Objeto de transferencia que contiene los datos para realizar la asignación
     */
    void asignarResponsabilidades(GDABienAsignacionDTO dto);


    /**
     * Listar todas las asignaciones que tienen un bien
     * @param idBien Identificador del Bien del cual se quieren listar las asignaciones
     * @param pageable Configuración del paginado para el listado devuelto
     * @return Una lista de GDABienAsignacionDTO con los valores de las asignaciones del Bien
     */
    Page<GDABienAsignacionResponseDTO> listadoAsignacionesDeUnBien(String idBien, Pageable pageable);


    String secuenciaCodigoUnidades(GdaUnidad unidad);


}
