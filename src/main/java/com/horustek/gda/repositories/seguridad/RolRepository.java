package com.horustek.gda.repositories.seguridad;
import com.horustek.gda.model.domain.GdaRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RolRepository extends JpaRepository<GdaRol, String> {

    Optional<GdaRol> findByNombre(String nombreRol);
    Optional<GdaRol> findById(String id);
    boolean existsByNombreIgnoreCase(String nombreRol);

    @Modifying
    @Query(nativeQuery =true,value = "DELETE from gda_usuario_roles as e WHERE e.gda_usuario_id = :usuarioId")
    int removeRolsToUserById(@Param("usuarioId") String usuarioId);
}
