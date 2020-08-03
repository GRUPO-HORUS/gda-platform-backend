package com.horustek.gda.services.seguridad.usuario;

import com.horustek.gda.model.domain.GdaUsuario;
import com.horustek.gda.shared.dto.seguridad.GdaUsuarioDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface UsuarioService {

    GdaUsuario obtenerPorNombreUsuario(String nombreUsuario);

    /**
     * Obtener todos los Usuarios del sistema
     *
     * @param pageable : Configuration de paginación
     * @return Listado paginado de todos los usuarios
     */
    Page<GdaUsuarioDTO> findAll(Pageable pageable);
}
