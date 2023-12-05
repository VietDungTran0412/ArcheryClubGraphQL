package com.techdes.archery.resolver;

import com.archery.packagename.types.EquipmentInput;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.techdes.archery.entity.Category;
import com.techdes.archery.entity.Equipment;
import com.techdes.archery.entity.Range;
import com.techdes.archery.entity.RoundType;
import com.techdes.archery.facade.CommonFacade;
import com.techdes.archery.mapper.EquipmentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@DgsComponent
@RequiredArgsConstructor
@Slf4j
public class CommonResolver {
    private final CommonFacade commonFacade;
    @DgsQuery
    public List<Equipment> getAllEquipments() {
        log.info("Starting get all equipments from archery db");
        return commonFacade.findAllEquipments();
    }

    @DgsQuery
    public List<RoundType> getRoundTypes() {
        log.info("Starting get round types from archery club");
        return commonFacade.findAllRoundTypes();
    }

    @DgsQuery
    public List<Category> getCategories() {
        log.info("Starting get all categories from archery club");
        return commonFacade.findAllCategories();
    }

    @DgsQuery
    public List<Range> getRanges() {
        log.info("Starting get ranges from archery club");
        return commonFacade.findAllRanges();
    }

    @DgsMutation
    public List<Equipment> saveEquipments(List<EquipmentInput> equipments)  {
        log.info("Starting saving equipments into archery club");
        return commonFacade.saveEquipments(equipments, EquipmentMapper.INSTANCE::toEquipment);
    }
}
