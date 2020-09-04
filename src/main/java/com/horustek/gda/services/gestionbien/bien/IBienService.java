package com.horustek.gda.services.gestionbien.bien;

import com.horustek.gda.shared.dto.gestionbienes.GDABienDTO;
import com.horustek.gda.shared.dto.gestionbienes.GDABienTipoDTO;
import com.horustek.gda.shared.dto.gestionbienes.RegistroBienDTO;
import com.horustek.gda.shared.dto.seguridad.GdaUsuarioDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
}
