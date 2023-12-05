package com.techdes.archery.response;

import com.techdes.archery.entity.Archer;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Data
public class AuthResponse {
    private Archer archer;
    private String accessToken;
}
