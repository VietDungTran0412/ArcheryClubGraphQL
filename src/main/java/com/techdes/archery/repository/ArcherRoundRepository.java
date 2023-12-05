package com.techdes.archery.repository;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.Predicate;
import com.techdes.archery.entity.ArcherRound;
import com.techdes.archery.input.LeaderboardInput;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface ArcherRoundRepository extends BaseRepository<Long, ArcherRound> {
    Optional<ArcherRound> findById(Long id);
    List<Tuple> search(Predicate predicate);
}
