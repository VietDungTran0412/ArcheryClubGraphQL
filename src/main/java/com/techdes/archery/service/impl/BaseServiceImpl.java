package com.techdes.archery.service.impl;

import com.querydsl.core.types.Predicate;
import com.techdes.archery.repository.BaseRepository;
import com.techdes.archery.repository.impl.BaseRepositoryImpl;
import com.techdes.archery.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl<I extends Serializable, T, R extends BaseRepository<I,T>> implements BaseService<I, T> {
    protected final R repository;
    protected BaseServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public Optional<T> findById(I id) {
        return repository.findById(id);
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public List<T> saveAll(Collection<T> entities) {
        return repository.saveAll(entities);
    }
}
