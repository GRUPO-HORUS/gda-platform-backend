package com.horustek.gda.repositories.seguridad;

import com.horustek.gda.model.domain.GdaRol;
import com.horustek.gda.model.domain.GdaUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolRepository extends JpaRepository<GdaRol, String> {

    Optional<GdaRol> findByNombre(String nombreRol);
    Optional<GdaRol> findById(String id);
    boolean existsByNombreIgnoreCase(String nombreRol);
}
