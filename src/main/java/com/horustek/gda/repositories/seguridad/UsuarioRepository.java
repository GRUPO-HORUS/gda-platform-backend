package com.horustek.gda.repositories.seguridad;

import com.horustek.gda.model.domain.GdaUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  UsuarioRepository extends JpaRepository<GdaUsuario, String> {
    Optional <GdaUsuario> findByUsernameIgnoreCase(String username);

    Boolean existsByUsernameIgnoreCase(String username);

    Boolean existsByEmailIgnoreCase(String email);

    Optional<GdaUsuario> findByEmailIgnoreCase(String email);


}
