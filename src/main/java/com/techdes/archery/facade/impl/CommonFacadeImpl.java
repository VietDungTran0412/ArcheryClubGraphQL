package com.techdes.archery.facade.impl;

import com.archery.packagename.types.EquipmentInput;
import com.techdes.archery.entity.Category;
import com.techdes.archery.entity.Equipment;
import com.techdes.archery.entity.Range;
import com.techdes.archery.entity.RoundType;
import com.techdes.archery.facade.CommonFacade;
import com.techdes.archery.facade.annotation.Facade;
import com.techdes.archery.service.CategoryService;
import com.techdes.archery.service.EquipmentService;
import com.techdes.archery.service.RangeService;
import com.techdes.archery.service.RoundTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Facade
@RequiredArgsConstructor
@Slf4j
public class CommonFacadeImpl implements CommonFacade {
    private final EquipmentService equipmentService;
    private final RangeService rangeService;
    private final CategoryService categoryService;
    private final RoundTypeService roundTypeService;
    @Override
    public List<Equipment> findAllEquipments() {
        log.info("Successfully get all equipments from archery db");
        return equipmentService.findAll();
    }
    @Override
    public List<Range> findAllRanges() {
        return rangeService.findAll();
    }

    @Override
    public List<Category> findAllCategories() {
        List<Category> all = categoryService.findAll();
        return all;
    }

    @Override
    public List<RoundType> findAllRoundTypes() {
        return roundTypeService.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Equipment> saveEquipments(List<EquipmentInput> equipments, Function<EquipmentInput, Equipment> mapper) {
        List<Equipment> entities = equipments.stream().map(mapper).collect(Collectors.toList());
        return equipmentService.saveAll(entities);
    }
}
