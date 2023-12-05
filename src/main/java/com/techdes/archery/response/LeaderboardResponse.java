package com.techdes.archery.response;

import com.archery.packagename.types.RoundType;
import com.techdes.archery.entity.Archer;
import com.techdes.archery.entity.Category;
import com.techdes.archery.entity.enumeration.Gender;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LeaderboardResponse {
    private Integer archerId;
    private Integer ranking;
    private String firstname;
    private String lastname;
    private Gender gender;
    private Integer score;
    private String ageRange;
    private String roundType;
}
