package com.horustek.gda.repositories.gestionbienes;

import com.horustek.gda.model.domain.GdaBien;
import com.horustek.gda.model.domain.GdaBienAsignaciones;
import com.horustek.gda.model.domain.GdaUsuario;
import com.horustek.gda.model.domain.enumeradores.BienEstadoEnum;
import com.horustek.gda.model.domain.enumeradores.BienTipoAsignacionEnum;
import com.horustek.gda.model.domain.enumeradores.EstadoInactividadEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BienAsignacionesRepository extends JpaRepository<GdaBienAsignaciones, String> {

    List<GdaBienAsignaciones> findByGdaBienIdAndGdaUsuarioIdAndTipoAsignacionAndEstado(GdaBien gdaBienId,
                                                                              GdaUsuario gdaUsuarioId,
                                                                              BienTipoAsignacionEnum tipoAsignacion, EstadoInactividadEnum estado);

    Page<GdaBienAsignaciones> findByGdaBienId(GdaBien gdaBien, Pageable pageable);
}
