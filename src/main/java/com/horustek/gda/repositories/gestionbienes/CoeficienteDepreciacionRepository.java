package com.horustek.gda.repositories.gestionbienes;

import com.horustek.gda.model.domain.GdaBienDatosContables;
import com.horustek.gda.model.domain.GdaCoeficienteDepreciacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CoeficienteDepreciacionRepository extends JpaRepository<GdaCoeficienteDepreciacion, String> {

    Optional<GdaCoeficienteDepreciacion> findByAnno(int anno);
}
