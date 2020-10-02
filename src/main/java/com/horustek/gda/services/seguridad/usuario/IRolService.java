package com.horustek.gda.services.seguridad.usuario;

import com.horustek.gda.infra.validation.ExistsRolByName;
import com.horustek.gda.infra.validation.ExistsUserByUsername;
import com.horustek.gda.model.domain.GdaRol;
import com.horustek.gda.shared.dto.seguridad.GdaRolDTO;
import com.horustek.gda.shared.dto.seguridad.GdaUsuarioDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface IRolService {

    /**
     * Obtener todos los Roles del sistema
     *
     * @param pageable : Configuration de paginación
     * @return Listado paginado de todos los roles
     */
    Page<GdaRolDTO>findAll(Pageable pageable);

    /**
     * Obtener el listado de roles de un usuario
     * @param idUsuario Identificador del usuario del cual se quieren conocer sus roles
     * @return Listado de un DTO con todos los roles del usuario
     */
    List<GdaRolDTO>findAllUserRol(String idUsuario);

    void asignarRolesAUsuario(String idUsuario, List<GdaRol> listadoRoles);

    void eliminarRolesAUsuario(String idUsuario);

}
