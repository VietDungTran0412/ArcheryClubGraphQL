package com.techdes.archery.facade;

import com.techdes.archery.entity.ArcherRound;
import com.techdes.archery.input.EndInput;
import com.techdes.archery.input.LeaderboardInput;
import com.techdes.archery.response.LeaderboardResponse;

import java.util.List;

public interface ArcherRoundFacade {
    ArcherRound createRound(Integer archerId,Integer categoryId, Integer equipmentId, Integer roundTypeId);
    ArcherRound getArcherRoundById(String id);
    List<LeaderboardResponse> searchByLeaderboardInput(LeaderboardInput input);
    ArcherRound addEndScore(EndInput end);
}
