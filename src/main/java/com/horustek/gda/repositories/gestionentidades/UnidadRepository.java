package com.horustek.gda.repositories.gestionentidades;

import com.horustek.gda.model.domain.GdaUnidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UnidadRepository extends JpaRepository<GdaUnidad, String>, JpaSpecificationExecutor<GdaUnidad> {

    @Modifying
    @Query("update GdaUnidad u set u.gdaUnidadPadreId = :idUnidadPadre where u in (:unidades) ")
    void actualizarUnidadPadre(String idUnidadPadre, List<GdaUnidad> unidades);

    List<GdaUnidad> findGdaUnidadByIdIn(List<String> ids);
}
