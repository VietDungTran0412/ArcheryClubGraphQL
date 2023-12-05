package com.techdes.archery.facade;

import com.archery.packagename.types.EquipmentInput;
import com.techdes.archery.entity.Category;
import com.techdes.archery.entity.Equipment;
import com.techdes.archery.entity.Range;
import com.techdes.archery.entity.RoundType;

import java.util.List;
import java.util.function.Function;

public interface CommonFacade {
    List<Equipment> findAllEquipments();
    List<Range> findAllRanges();
    List<Category> findAllCategories();
    List<RoundType> findAllRoundTypes();
    List<Equipment> saveEquipments(List<EquipmentInput> equipments, Function<EquipmentInput, Equipment> mapper);
}
