package com.techdes.archery.repository.impl;

import com.techdes.archery.entity.QRoundType;
import com.techdes.archery.entity.RoundType;
import com.techdes.archery.repository.RoundTypeRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class RoundTypeRepositoryImpl extends BaseRepositoryImpl<Integer, RoundType> implements RoundTypeRepository {
    protected RoundTypeRepositoryImpl(EntityManager em) {
        super(RoundType.class, em);
    }
    @Override
    public List<RoundType> findAll() {
        QRoundType roundType = QRoundType.roundType;
        List<RoundType> roundTypes = queryFactory.selectFrom(roundType).distinct()
                .leftJoin(roundType.ranges)
                .fetchJoin()
                .fetch();

        return roundTypes;
    }
}
