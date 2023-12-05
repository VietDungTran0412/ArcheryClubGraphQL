package com.techdes.archery.service;

import com.techdes.archery.entity.Archer;
import com.techdes.archery.entity.ArcherRound;
import com.techdes.archery.input.LeaderboardInput;

import java.util.List;
import java.util.Optional;

public interface ArcherService extends BaseService<Integer, Archer> {
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);
    Optional<Archer> findByEmail(String email);
    Optional<Archer> loadById(Integer id);
}
