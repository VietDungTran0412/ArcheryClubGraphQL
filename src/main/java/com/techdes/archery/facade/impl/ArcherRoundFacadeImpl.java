package com.techdes.archery.facade.impl;

import com.querydsl.core.Tuple;
import com.techdes.archery.entity.*;
import com.techdes.archery.entity.enumeration.Gender;
import com.techdes.archery.exception.EndLimitException;
import com.techdes.archery.exception.NotExistedException;
import com.techdes.archery.facade.ArcherRoundFacade;
import com.techdes.archery.facade.annotation.Facade;
import com.techdes.archery.input.EndInput;
import com.techdes.archery.input.LeaderboardInput;
import com.techdes.archery.mapper.RoundMapper;
import com.techdes.archery.response.LeaderboardResponse;
import com.techdes.archery.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Facade
@RequiredArgsConstructor
@Slf4j
public class ArcherRoundFacadeImpl implements ArcherRoundFacade {
    private final ArcherRoundService archerRoundService;
    private final ArcherService archerService;
    private final CategoryService categoryService;
    private final RoundTypeService roundTypeService;
    private final EndService endService;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ArcherRound createRound(Integer archerId,Integer categoryId, Integer equipmentId, Integer roundTypeId) {
        log.info("Process of creating round into archery club");
        final Optional<Archer> archerWrapper = archerService.findById(archerId);
        if(!archerWrapper.isPresent()) {
            log.error("Archer does not exist");
            throw new NotExistedException("Archer does not exist!");
        }
        final Optional<Category> categoryWrapper = categoryService.findById(categoryId);
        if(!categoryWrapper.isPresent()) {
            log.error("Category does not exist");
            throw new NotExistedException("Category does not exist");
        }
        Optional<Equipment> equipmentWrapper = Optional.empty();
        for(Equipment e : categoryWrapper.get().getEquipments()) {
            if (e.getId() == equipmentId) {
                equipmentWrapper = Optional.of(e);
            }
        }
        if(!equipmentWrapper.isPresent()) {
            throw new NotExistedException("Equipment does not exist in scope of category!");
        }
        Optional<RoundType> roundTypeWrapper = roundTypeService.findById(roundTypeId);
        if(!roundTypeWrapper.isPresent()) {
            throw new NotExistedException("Round Type does not exist!");
        }
        ArcherRound entity = new ArcherRound();
        entity.setArcher(archerWrapper.get());
        entity.setRoundType(roundTypeWrapper.get());
        entity.setCategory(categoryWrapper.get());
        entity.setEquipment(equipmentWrapper.get());
        entity.setCreatedDate(new Date());
        log.info("Created archer round in archery club");
        return archerRoundService.save(entity);
    }

    @Override
    public ArcherRound getArcherRoundById(String id) {
        log.info("Getting archer round with id {}", id);
        Long longId;
        try {
            longId = Long.valueOf(id);
        }catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid id format");
        }
        Optional<ArcherRound> wrapper = archerRoundService.findById(longId);
        if(!wrapper.isPresent()) {
            throw new NotExistedException("Archer round does not exist with provided id");
        }
        return wrapper.get();
    }

    @Override
    public List<LeaderboardResponse> searchByLeaderboardInput(LeaderboardInput input) {
        List<Tuple> archerRounds = archerRoundService.searchByLeaderboardInput(input);
        AtomicReference<Integer> count = new AtomicReference<>(1);
        List<LeaderboardResponse> responses = archerRounds.stream().map((tuple) -> {
           LeaderboardResponse resp = LeaderboardResponse.builder()
                   .ranking(count.get())
                   .firstname(tuple.get(0, String.class))
                   .lastname(tuple.get(1, String.class))
                   .roundType(tuple.get(2, String.class))
                   .ageRange(tuple.get(3, String.class))
                   .gender(tuple.get(4, Gender.class))
                   .score(tuple.get(5, Integer.class))
                   .archerId(tuple.get(6, Integer.class))
                   .build();
           count.getAndSet(count.get() + 1);
           return resp;
        }).collect(Collectors.toList());
        log.info("Getting {} result from archery db", archerRounds.size());
        return responses;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ArcherRound addEndScore(EndInput end) {
        RoundMapper roundMapper = RoundMapper.INSTANCE;

        Long id;
        try {
            id = Long.valueOf(end.getRoundId());
        }catch (NumberFormatException e) {
            log.error("Invalid id format: {}", end.getRoundId());
            throw new NumberFormatException("Invalid round id format");
        }
        Optional<ArcherRound> wrapper = archerRoundService.findById(id);
        if(!wrapper.isPresent()) {
            throw new NotExistedException("Archer round is not existed");
        }
        ArcherRound archerRound = wrapper.get();
        List<End> savedEnds = roundMapper.mapScoresInput(end.getScores(), archerRound);
        archerRound.getEnds().addAll(savedEnds);
        if(archerRound.getEnds().size() > archerRoundService.getMaxEnd(archerRound)) {
            throw new EndLimitException("Archer round reached the limit number of ends");
        }
        endService.saveAll(savedEnds);
        return archerRound;
    }
}
