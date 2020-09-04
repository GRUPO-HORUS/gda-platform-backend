package com.horustek.gda.repositories.gestionbienes;

import com.horustek.gda.model.domain.GdaBien;
import com.horustek.gda.model.domain.GdaBienFijoDatos;
import com.horustek.gda.model.domain.GdaUnidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BienFijoDatosRepository extends JpaRepository<GdaBienFijoDatos, String> , JpaSpecificationExecutor<GdaBienFijoDatos> {

}
