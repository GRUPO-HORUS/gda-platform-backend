package com.horustek.gda.repositories.gestionentidades;

import com.horustek.gda.model.domain.GdaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EntidadRepository extends JpaRepository<GdaEntidad, String> {

    Optional<GdaEntidad> findByNombre(String nombre);




}
