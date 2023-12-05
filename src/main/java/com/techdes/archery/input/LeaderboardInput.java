package com.techdes.archery.input;

import lombok.Builder;
import lombok.Data;

@Data
public class LeaderboardInput {
    private Integer categoryId ;
    private Integer roundTypeId;
    private String firstname;
    private String lastname;
}
