package com.techdes.archery.mapper;

import com.techdes.archery.entity.Archer;
import com.techdes.archery.input.ArcherInput;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ArcherMapper {
    ArcherMapper INSTANCE = Mappers.getMapper(ArcherMapper.class);

    Archer toArcher(ArcherInput archer);
}
