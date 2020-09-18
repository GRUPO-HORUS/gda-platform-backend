package com.horustek.gda.repositories.gestionbienes;

import com.horustek.gda.model.domain.GdaBien;
import com.horustek.gda.model.domain.GdaUnidad;
import com.horustek.gda.model.domain.enumeradores.BienEstadoEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BienRepository extends JpaRepository<GdaBien, String> {

    List<GdaBien> findByRotuladoIsNotNullOrderByFechaCreacionDesc();

    Optional<GdaBien> findByRotulado(String rotulado);

    List<GdaBien> findGdaBienByBienEstadoIn(List<BienEstadoEnum> estados);


}
