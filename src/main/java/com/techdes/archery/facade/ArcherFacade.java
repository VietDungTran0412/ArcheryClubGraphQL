package com.techdes.archery.facade;

import com.archery.packagename.types.AuthInput;
import com.techdes.archery.entity.Archer;
import com.techdes.archery.entity.ArcherRound;
import com.techdes.archery.input.ArcherInput;
import com.techdes.archery.input.LeaderboardInput;
import com.techdes.archery.response.AuthResponse;
import com.techdes.archery.response.LeaderboardResponse;

import java.util.List;
import java.util.function.Function;

public interface ArcherFacade {
    AuthResponse saveArcher(ArcherInput archerInput, Function<ArcherInput, Archer> mapper);
    AuthResponse doLogin(AuthInput authInput);
    String doLogout(String header);
    Archer findById(Integer id);
}
