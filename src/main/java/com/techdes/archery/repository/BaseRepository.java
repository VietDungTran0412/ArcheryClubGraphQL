package com.techdes.archery.repository;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<I extends Serializable,T> extends JpaRepositoryImplementation<T,I> {
    Page<T> findAll(JPAQuery<T> query, Pageable pageable);
    Page<T> findAll(Predicate predicate, Pageable pageable);
    List<T> findAll(Predicate predicate);
    Optional<T> findOne(Predicate predicate);
    boolean exists(Predicate predicate);
}
