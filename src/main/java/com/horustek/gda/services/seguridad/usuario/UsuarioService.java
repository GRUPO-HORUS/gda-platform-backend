package com.horustek.gda.services.seguridad.usuario;

import com.horustek.gda.infra.validation.ExistsUserByUsername;
import com.horustek.gda.shared.dto.seguridad.GdaUsuarioDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;

@Validated
public interface UsuarioService {

    /**
     * Encontrar Usuario por nombre de usuario
     *
     * @param nombreUsuario Nombre de Usuario
     * @return Homiefoo User
     */
    GdaUsuarioDTO findByUsername(@ExistsUserByUsername String nombreUsuario);

    /**
     * Obtener todos los Usuarios del sistema
     *
     * @param pageable : Configuration de paginación
     * @return Listado paginado de todos los usuarios
     */
    Page<GdaUsuarioDTO> findAll(Pageable pageable);


}
