package com.horustek.gda.repositories.gestionbienes;

import com.horustek.gda.model.domain.GdaCategoriaBien;
import com.horustek.gda.model.domain.GdaUnidad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<GdaCategoriaBien, String>, JpaSpecificationExecutor<GdaCategoriaBien> {

    @Query( "select o from GdaCategoriaBien o where o.gdaCategoriaBienId is null " )
    Page<GdaCategoriaBien> findCategoriaBase(Pageable pageable);

    Page<GdaCategoriaBien> findAllByGdaCategoriaBienId(GdaCategoriaBien gdaCategoriaBien, Pageable pageable);


}
