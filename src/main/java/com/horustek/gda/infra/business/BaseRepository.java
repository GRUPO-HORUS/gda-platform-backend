package com.horustek.gda.infra.business;

import com.horustek.gda.infra.auditoria.Auditable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseRepository<E extends Auditable, K> extends JpaRepository<E, K> {

}


