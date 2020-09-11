package com.horustek.gda.repositories.gestionbienes;

import com.horustek.gda.model.domain.GdaCoeficienteRevaluo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CoeficienteDepreciacionRepository extends JpaRepository<GdaCoeficienteRevaluo, String> {

    Optional<GdaCoeficienteRevaluo> findByAnno(int anno);
}
