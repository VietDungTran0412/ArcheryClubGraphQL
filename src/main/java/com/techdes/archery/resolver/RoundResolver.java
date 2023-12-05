package com.techdes.archery.resolver;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.techdes.archery.entity.ArcherRound;
import com.techdes.archery.facade.ArcherRoundFacade;
import com.techdes.archery.input.EndInput;
import com.techdes.archery.input.LeaderboardInput;
import com.techdes.archery.response.LeaderboardResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@DgsComponent
@Slf4j
@RequiredArgsConstructor
public class RoundResolver {
    private final ArcherRoundFacade archerRoundFacade;

    @DgsMutation
    @PreAuthorize("hasAnyAuthority('ADMIN', 'ARCHER', 'RECORDER')")
    public ArcherRound createRound(Integer archer, Integer category,Integer equipment, Integer roundType) {
        log.info("Starting creating round into archery club");
        return archerRoundFacade.createRound(archer, category, equipment, roundType);
    }
    @DgsQuery
    @PreAuthorize("hasAnyAuthority('ADMIN', 'ARCHER', 'RECORDER')")
    public ArcherRound getArcherRound(String id) {
        log.info("Getting archer round with id from archery with: {}", id);
        return archerRoundFacade.getArcherRoundById(id);
    }
    @DgsMutation
    @PreAuthorize("hasAnyAuthority('ADMIN','ARCHER','RECORDER')")
    public ArcherRound addScore(@Valid EndInput end) {
        log.info("Starting adding score into archery club with round id: {}", end.getRoundId());
        return archerRoundFacade.addEndScore(end);
    }

    @DgsQuery
    public Iterable<LeaderboardResponse> getLeaderboard(LeaderboardInput input) {
        log.info("Leaderboard from archery");
         return archerRoundFacade.searchByLeaderboardInput(input);
    }
}
