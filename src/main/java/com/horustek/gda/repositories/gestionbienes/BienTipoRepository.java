package com.horustek.gda.repositories.gestionbienes;

import com.horustek.gda.model.domain.GdaBienTipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BienTipoRepository extends JpaRepository<GdaBienTipo, String> {
}
