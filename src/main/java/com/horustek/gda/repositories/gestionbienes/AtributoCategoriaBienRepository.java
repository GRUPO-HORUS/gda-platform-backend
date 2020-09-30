package com.horustek.gda.repositories.gestionbienes;

import com.horustek.gda.model.domain.*;
import com.horustek.gda.model.domain.enumeradores.BienTipoAsignacionEnum;
import com.horustek.gda.model.domain.enumeradores.EstadoInactividadEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtributoCategoriaBienRepository extends JpaRepository<GdaAtributoCategoriaBien, String> {

   List<GdaAtributoCategoriaBien> findByGdaCategoriaBienId(GdaCategoriaBien gdaCategoriaBien);

}
