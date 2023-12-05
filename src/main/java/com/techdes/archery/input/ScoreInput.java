package com.techdes.archery.input;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class ScoreInput {
    @Min(0)
    @Max(60)
    private Integer end1;
    @Min(0)
    @Max(60)
    private Integer end2;
    @Min(0)
    @Max(60)
    private Integer end3;
    @Min(0)
    @Max(60)
    private Integer end4;
    @Min(0)
    @Max(60)
    private Integer end5;
    @Min(0)
    @Max(60)
    private Integer end6;
}
