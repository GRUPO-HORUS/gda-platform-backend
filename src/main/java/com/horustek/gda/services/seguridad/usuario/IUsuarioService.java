package com.horustek.gda.services.seguridad.usuario;

import com.horustek.gda.infra.validation.ExistsUserById;
import com.horustek.gda.infra.validation.ExistsUserByUsername;
import com.horustek.gda.model.domain.GdaRol;
import com.horustek.gda.model.domain.GdaUnidad;
import com.horustek.gda.model.domain.GdaUsuario;
import com.horustek.gda.shared.dto.seguridad.GdaRolDTO;
import com.horustek.gda.shared.dto.seguridad.GdaUsuarioDTO;
import com.horustek.gda.shared.dto.seguridad.RegistroDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Validated
public interface IUsuarioService {

    /**
     * Encontrar Usuario por nombre de usuario
     *
     * @param nombreUsuario Nombre de Usuario
     * @return GdaUsuarioDTO User
     */
    GdaUsuarioDTO findByUsername(@ExistsUserByUsername String nombreUsuario);

    GdaUnidad findUnidadFromUser(String nombreUsuario) ;

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

    /**
     * Obtener el listado de usuarios que tienen un rol especifico dentro de una unidad especifica
     * @param nombreRol Rol especifico que se busca
     * @param idUnidad Identificador de la unidad en la cual se van a buscar los usuarios con el Rol ingresado
     * @return
     */
    Page<GdaUsuarioDTO> listadoUsuarioConUnRolEnUnaUnidad(String nombreRol, String idUnidad, Pageable pageable);

    /**
     * Obtener listado paginado de usuarios de una unidad
     * @param idUnidad Identificador de la unidad de la cual se quieren conocer sus usuarios
     * @return
     */
    Page<GdaUsuarioDTO> obtenerUsuarioDadoIdUnidad(String idUnidad, Pageable pageable);


}
