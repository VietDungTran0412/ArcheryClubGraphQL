package com.techdes.archery.repository.impl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.techdes.archery.entity.Archer;
import com.techdes.archery.entity.QArcher;
import com.techdes.archery.repository.ArcherRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
public class ArcherRepositoryImpl extends BaseRepositoryImpl<Integer, Archer> implements ArcherRepository {
    protected ArcherRepositoryImpl(EntityManager em) {
        super(Archer.class, em);
    }

    @Override
    public Optional<Archer> loadById(Integer id) {
        QArcher archer = QArcher.archer;
        BooleanExpression where = archer.id.eq(id);
        Archer res = queryFactory.selectFrom(archer)
                .distinct()
                .where(where)
                .leftJoin(archer.archerRounds)
                .fetchJoin()
                .fetchOne();
        return Optional.ofNullable(res);
    }
}
