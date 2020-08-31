package com.horustek.gda.repositories.gestionEntidades;

import com.horustek.gda.model.domain.GdaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntidadRepository extends JpaRepository<GdaEntidad, String> {

    Boolean findByNombre(String nombre);
}
