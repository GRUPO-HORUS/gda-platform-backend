package com.horustek.gda.services.seguridad.usuario;

import com.horustek.gda.infra.validation.ExistsUserById;
import com.horustek.gda.infra.validation.ExistsUserByUsername;
import com.horustek.gda.shared.dto.seguridad.GdaUsuarioDTO;
import com.horustek.gda.shared.dto.seguridad.RegistroDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Validated
public interface UsuarioService {

    /**
     * Encontrar Usuario por nombre de usuario
     *
     * @param nombreUsuario Nombre de Usuario
     * @return GdaUsuarioDTO User
     */
    GdaUsuarioDTO findByUsername(@ExistsUserByUsername String nombreUsuario);

    /**
     * Obtener todos los Usuarios del sistema
     *
     * @param pageable : Configuration de paginación
     * @return Listado paginado de todos los usuarios
     */
    Page<GdaUsuarioDTO> findAll(Pageable pageable);

    /**
     * Get Usuario GDA por id
     *
     * @param id Identificador del usuario GDA
     * @return GdaUsuarioDTO. Se retorna el DTO correspondiente a los valores necesitados para la entidad usuario
     */
    GdaUsuarioDTO findById(@ExistsUserById String id);

    /**
     * Registrar un usuario
     *
     * @param registroDTO Datos del registro
     */
    void register(@Valid RegistroDTO registroDTO);


}
