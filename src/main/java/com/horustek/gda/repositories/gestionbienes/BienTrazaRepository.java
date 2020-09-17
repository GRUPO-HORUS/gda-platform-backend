package com.horustek.gda.repositories.gestionbienes;

import com.horustek.gda.model.domain.GdaBien;
import com.horustek.gda.model.domain.GdaBienTraza;
import com.horustek.gda.model.domain.GdaCategoriaBien;
import com.horustek.gda.model.domain.GdaUsuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BienTrazaRepository extends JpaRepository<GdaBienTraza, String> {

    Page<GdaBienTraza> findAllByGdaBienId(GdaBien gdaBien, Pageable pageable);

}
