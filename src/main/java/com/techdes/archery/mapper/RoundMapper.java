package com.techdes.archery.mapper;

import com.techdes.archery.entity.ArcherRound;
import com.techdes.archery.entity.End;
import com.techdes.archery.input.ScoreInput;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.Arrays;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoundMapper {
    RoundMapper INSTANCE = Mappers.getMapper(RoundMapper.class);
    default List<End> mapScoresInput(ScoreInput scoreInput, ArcherRound round) {
        End end1 = new End(round,scoreInput.getEnd1());
        End end2 = new End(round,scoreInput.getEnd2());
        End end3 = new End(round,scoreInput.getEnd3());
        End end4 = new End(round,scoreInput.getEnd4());
        End end5 = new End(round,scoreInput.getEnd5());
        if(scoreInput.getEnd6() != null) {
            End end6 = new End(round,scoreInput.getEnd6());
            return Arrays.asList(end1, end2, end3, end4, end5, end6);
        }

        return Arrays.asList(end1, end2, end3, end4, end5);
    }
}
