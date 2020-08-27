package com.horustek.gda.repositories.seguridad;

import com.horustek.gda.model.domain.GdaUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<GdaUsuario, String>, JpaSpecificationExecutor<GdaUsuario> {
    Optional<GdaUsuario> findByNombreUsuarioIgnoreCase(String username);

    Boolean existsByNombreUsuarioIgnoreCase(String username);

    Boolean existsByEmailIgnoreCase(String email);

    Optional<GdaUsuario> findByEmailIgnoreCase(String email);


}
