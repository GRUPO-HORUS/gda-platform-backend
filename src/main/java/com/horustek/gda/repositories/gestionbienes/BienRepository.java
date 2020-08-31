package com.horustek.gda.repositories.gestionbienes;

import com.horustek.gda.model.domain.GdaBien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BienRepository extends JpaRepository<GdaBien, String> {
}
