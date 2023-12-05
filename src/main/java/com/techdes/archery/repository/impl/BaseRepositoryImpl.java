package com.techdes.archery.repository.impl;

import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.techdes.archery.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.Querydsl;
import org.springframework.data.jpa.repository.support.QuerydslJpaPredicateExecutor;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.querydsl.SimpleEntityPathResolver;
import org.springframework.data.support.PageableExecutionUtils;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseRepositoryImpl<I extends Serializable, T> extends SimpleJpaRepository<T, I> implements BaseRepository<I, T> {
    protected final EntityManager em;
    protected final JPAQueryFactory queryFactory;
    protected final QuerydslJpaPredicateExecutor<T> predicateExecutor;
    protected final Querydsl querydsl;
    protected final EntityPath<T> entityPath;
    protected BaseRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
        this.predicateExecutor = new QuerydslJpaPredicateExecutor<>(JpaEntityInformationSupport.getEntityInformation(domainClass, em),em , SimpleEntityPathResolver.INSTANCE, getRepositoryMethodMetadata());
        this.entityPath = SimpleEntityPathResolver.INSTANCE.createPath(domainClass);
        this.querydsl = new Querydsl(em, new PathBuilder<Object>(entityPath.getType(), entityPath.getMetadata()));
    }

    @Override
    public Page<T> findAll(Predicate predicate, Pageable pageable) {
        return this.predicateExecutor.findAll(predicate, pageable);
    }

    @Override
    public Page<T> findAll(JPAQuery<T> query, Pageable pageable) {
        JPQLQuery<T> queryCount = querydsl.applyPagination(pageable, query);
        return PageableExecutionUtils.getPage(query.fetch(), pageable, queryCount::fetchCount);
    }
    @Override
    public boolean exists(Predicate predicate) {
        Optional<T> entity = findOne(predicate);
        return entity.isPresent();
    }

    @Override
    public List<T> findAll(Predicate predicate) {
        return this.predicateExecutor.findAll(predicate);
    }
    @Override
    public Optional<T> findOne(Predicate predicate) {
        return predicateExecutor.findOne(predicate);
    }
}
