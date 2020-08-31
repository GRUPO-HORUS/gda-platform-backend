package com.horustek.gda.services.seguridad.usuario;

import com.horustek.gda.infra.validation.ExistsRolByName;
import com.horustek.gda.infra.validation.ExistsUserByUsername;
import com.horustek.gda.shared.dto.seguridad.GdaRolDTO;
import com.horustek.gda.shared.dto.seguridad.GdaUsuarioDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;

@Validated
public interface IRolService {

    /**
     * Obtener todos los Roles del sistema
     *
     * @param pageable : Configuration de paginación
     * @return Listado paginado de todos los roles
     */
    Page<GdaRolDTO>findAll(Pageable pageable);

}
