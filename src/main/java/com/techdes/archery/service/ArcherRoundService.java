package com.techdes.archery.service;

import com.querydsl.core.Tuple;
import com.techdes.archery.entity.ArcherRound;
import com.techdes.archery.input.LeaderboardInput;

import java.util.List;

public interface ArcherRoundService extends BaseService<Long, ArcherRound> {
    Integer getMaxScore(ArcherRound archerRound);
    Integer getMaxEnd(ArcherRound archerRound);
    List<Tuple> searchByLeaderboardInput(LeaderboardInput leaderboardInput);
}
