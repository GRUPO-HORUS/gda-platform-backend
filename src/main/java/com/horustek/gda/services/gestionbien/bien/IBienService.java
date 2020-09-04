package com.horustek.gda.services.gestionbien.bien;

import com.horustek.gda.shared.dto.gestionbienes.GdaDetalleBienDTO;
import com.horustek.gda.shared.dto.gestionbienes.GDABienDTO;
import com.horustek.gda.shared.dto.gestionbienes.GDABienTipoDTO;
import com.horustek.gda.shared.dto.gestionbienes.RegistroBienDTO;
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
}
