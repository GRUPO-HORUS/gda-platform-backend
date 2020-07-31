package com.horustek.gda.infra.business;

import com.horustek.gda.infra.auditoria.Auditable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BaseService<E extends Auditable, K>{

    E save(E entity);

    List<E> findAll();

    Page<E> findAll(Pageable p);

    E findById(K id);

    void remove(E entity);

}
