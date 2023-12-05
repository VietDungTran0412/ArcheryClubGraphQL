package com.techdes.archery.service;

import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface BaseService<I extends Serializable, T> {
    T save(T entity);
    Page<T> findAll(Pageable pageable);
    Optional<T> findById(I id);
    List<T> saveAll(Collection<T> entities);
    List<T> findAll();
}
