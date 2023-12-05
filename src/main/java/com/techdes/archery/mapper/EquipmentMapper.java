package com.techdes.archery.mapper;

import com.archery.packagename.types.EquipmentInput;
import com.techdes.archery.entity.Equipment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EquipmentMapper {
    EquipmentMapper INSTANCE = Mappers.getMapper(EquipmentMapper.class);
    Equipment toEquipment(EquipmentInput equipmentInput);
}
