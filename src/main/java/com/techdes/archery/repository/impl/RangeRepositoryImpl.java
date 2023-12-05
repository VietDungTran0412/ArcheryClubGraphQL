package com.techdes.archery.repository.impl;

import com.techdes.archery.entity.QRange;
import com.techdes.archery.entity.Range;
import com.techdes.archery.repository.RangeRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class RangeRepositoryImpl extends BaseRepositoryImpl<Integer, Range> implements RangeRepository {
    protected RangeRepositoryImpl(EntityManager em) {
        super(Range.class, em);
    }

    @Override
    public List<Range> findAll() {
        QRange range = QRange.range;
        List<Range> res = queryFactory.selectFrom(range)
                .leftJoin(range.distance)
                .leftJoin(range.roundType)
                .leftJoin(range.face)
                .fetchJoin()
                .fetch();

        return res;
    }
}
