package com.horustek.gda.repositories.gestionEntidades;

import com.horustek.gda.model.domain.GdaTipoUnidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoUnidadRepository extends JpaRepository<GdaTipoUnidad, String> {

    Boolean findByDescripcionIgnoreCase(String descripcion);
}
