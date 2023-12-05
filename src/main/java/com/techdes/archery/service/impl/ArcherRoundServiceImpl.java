package com.techdes.archery.service.impl;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.techdes.archery.entity.ArcherRound;
import com.techdes.archery.entity.QArcherRound;
import com.techdes.archery.entity.QEnd;
import com.techdes.archery.entity.Range;
import com.techdes.archery.input.LeaderboardInput;
import com.techdes.archery.repository.ArcherRoundRepository;
import com.techdes.archery.service.ArcherRoundService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArcherRoundServiceImpl extends BaseServiceImpl<Long, ArcherRound, ArcherRoundRepository> implements ArcherRoundService {
    protected ArcherRoundServiceImpl(ArcherRoundRepository repository) {
        super(repository);
    }

    @Override
    public Integer getMaxScore(ArcherRound archerRound) {
        Integer maxScore = 0;
        for(Range range : archerRound.getRoundType().getRanges()) {
            maxScore += 60 * range.getEndCount();
        }
        return maxScore;
    }

    @Override
    public Integer getMaxEnd(ArcherRound archerRound) {
        return 6 * archerRound.getRoundType().getRanges().size();
    }

    @Override
    public List<Tuple> searchByLeaderboardInput(LeaderboardInput leaderboardInput) {
        QArcherRound archerRound = QArcherRound.archerRound;
        QEnd end = QEnd.end;
        String firstnameLike = leaderboardInput.getFirstname() != null ? leaderboardInput.getFirstname() : "";
        String lastnameLike = leaderboardInput.getLastname() != null ? leaderboardInput.getLastname() : "";
        BooleanExpression where = archerRound.archer.firstname.likeIgnoreCase("%" + firstnameLike + "%")
                .and(archerRound.archer.lastname.likeIgnoreCase("%" + lastnameLike + "%"))
                .and(end.score.isNotNull());
        if(leaderboardInput.getRoundTypeId() != null) {
            where = where.and(archerRound.roundType.id.eq(leaderboardInput.getRoundTypeId()));
        }
        if(leaderboardInput.getCategoryId() != null) {
            where = where.and(archerRound.category.id.eq(leaderboardInput.getCategoryId()));
        }
        List<Tuple> result = repository.search(where);
        return result;
    }
}
