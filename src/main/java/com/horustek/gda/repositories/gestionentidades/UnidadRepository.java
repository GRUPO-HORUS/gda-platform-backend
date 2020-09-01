package com.horustek.gda.repositories.gestionentidades;

import com.horustek.gda.model.domain.GdaUnidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UnidadRepository extends JpaRepository<GdaUnidad, String>, JpaSpecificationExecutor<GdaUnidad> {


}
