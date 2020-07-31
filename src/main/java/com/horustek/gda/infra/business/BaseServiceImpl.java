package com.horustek.gda.infra.business;

import com.horustek.gda.infra.auditoria.Auditable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public abstract class BaseServiceImpl<E extends Auditable, K> implements BaseService<E, K> {

    private BaseRepository<E, K> baseRepository;

    @Autowired
    public BaseServiceImpl(BaseRepository<E, K> baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public E save(E entity) {
        return baseRepository.save(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<E> findAll() {
        Iterable<E> source = baseRepository.findAll();
        List<E> target = new ArrayList<>();
        source.forEach(target::add);
        return target;
    }

    @Override
    public Page<E> findAll(Pageable p) {
        return baseRepository.findAll(p);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public E findById(K id) {
        Optional<E> entity = baseRepository.findById(id);
        return entity.orElse(null);
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void remove(E entity) {
        baseRepository.delete(entity);
    }


}
