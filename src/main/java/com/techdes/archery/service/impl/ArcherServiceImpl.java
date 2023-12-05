package com.techdes.archery.service.impl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.techdes.archery.entity.Archer;
import com.techdes.archery.entity.ArcherRound;
import com.techdes.archery.entity.QArcher;
import com.techdes.archery.entity.QArcherRound;
import com.techdes.archery.input.LeaderboardInput;
import com.techdes.archery.repository.ArcherRepository;
import com.techdes.archery.service.ArcherService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArcherServiceImpl extends BaseServiceImpl<Integer, Archer, ArcherRepository> implements ArcherService {
    protected ArcherServiceImpl(ArcherRepository repository) {
        super(repository);
    }

    @Override
    public boolean existsByEmail(String email) {
        BooleanExpression where = QArcher.archer.email.eq(email);
        return repository.exists(where);
    }

    @Override
    public boolean existsByPhone(String phone) {
        BooleanExpression where = QArcher.archer.phone.eq(phone);
        return repository.exists(where);
    }

    @Override
    public Optional<Archer> findByEmail(String email) {
        BooleanExpression where = QArcher.archer.email.eq(email);
        return repository.findOne(where);
    }

    @Override
    public Optional<Archer> loadById(Integer id) {
        return repository.loadById(id);
    }


}
