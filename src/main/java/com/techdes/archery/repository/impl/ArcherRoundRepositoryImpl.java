package com.techdes.archery.repository.impl;

import com.querydsl.core.Tuple;
import com.querydsl.core.group.GroupBy;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.techdes.archery.entity.ArcherRound;
import com.techdes.archery.entity.QArcherRound;
import com.techdes.archery.entity.QEnd;
import com.techdes.archery.repository.ArcherRoundRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@Slf4j
public class ArcherRoundRepositoryImpl extends BaseRepositoryImpl<Long, ArcherRound> implements ArcherRoundRepository {
    protected ArcherRoundRepositoryImpl(EntityManager em) {
        super(ArcherRound.class, em);
    }
    @Override
    public Optional<ArcherRound> findById(Long id) {
        QArcherRound archerRound = QArcherRound.archerRound;
        BooleanExpression where = archerRound.id.eq(id);
        ArcherRound res = queryFactory.selectFrom(archerRound).distinct()
                .where(where)
                .leftJoin(archerRound.archer)
                .leftJoin(archerRound.roundType)
                .leftJoin(archerRound.category)
                .leftJoin(archerRound.equipment)
                .leftJoin(archerRound.ends)
                .fetchJoin()
                .fetchOne();
        return Optional.ofNullable(res);
    }

    @Override
    public List<Tuple> search(Predicate predicate) {
        QArcherRound archerRound = QArcherRound.archerRound;
        QEnd end = QEnd.end;
        List<Tuple> archerRounds = queryFactory
                    .select(archerRound.archer.firstname, archerRound.archer.lastname, archerRound.roundType.name, archerRound.category.ageRange, archerRound.category.gender, end.score.sum(), archerRound.archer.id)
                    .from(archerRound)
                    .where(predicate)
                    .leftJoin(archerRound.ends, end)
                    .groupBy(archerRound.archer, archerRound.roundType, archerRound.category)
                    .orderBy(end.score.sum().desc())
                    .fetch();
        return archerRounds;
    }
}
