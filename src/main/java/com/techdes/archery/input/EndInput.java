package com.techdes.archery.input;

import lombok.Data;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Data
public class EndInput {
    private String roundId;
    private ScoreInput scores;
}
