package com.techdes.archery.facade.impl;
import com.archery.packagename.types.AuthInput;
import com.techdes.archery.entity.Archer;
import com.techdes.archery.entity.ArcherRound;
import com.techdes.archery.entity.BlackListToken;
import com.techdes.archery.entity.enumeration.Role;
import com.techdes.archery.exception.ExistedException;
import com.techdes.archery.facade.ArcherFacade;
import com.techdes.archery.facade.annotation.Facade;
import com.techdes.archery.input.ArcherInput;
import com.techdes.archery.input.LeaderboardInput;
import com.techdes.archery.response.AuthResponse;
import com.techdes.archery.response.LeaderboardResponse;
import com.techdes.archery.service.ArcherService;
import com.techdes.archery.service.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Facade
@RequiredArgsConstructor
@Slf4j
public class ArcherFacadeImpl implements ArcherFacade {
    private final ArcherService archerService;
    private final HttpServletRequest request;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authManager;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public AuthResponse saveArcher(ArcherInput archerInput, Function<ArcherInput, Archer> mapper) {
        log.info("Register into archery");
        Archer entity = mapper.apply(archerInput);
        if(archerService.existsByEmail(entity.getEmail())) {
            throw new ExistedException("Archer already existed with provided email");
        }
        if(archerService.existsByPhone(entity.getPhone())) {
            throw new ExistedException("Archer already existed with provided phone number");
        }
        entity.setPassword(passwordEncoder.encode(archerInput.getPassword()));
        entity.setRole(Role.ARCHER);
        Archer savedArcher = archerService.save(entity);
        final String accessToken  = jwtService.generateToken(savedArcher);
        return AuthResponse.builder().archer(savedArcher).accessToken(accessToken).build();
    }

    @Override
    public AuthResponse doLogin(AuthInput authInput) {
        final Optional<Archer> archerWrapper = archerService.findByEmail(authInput.getEmail());
        if(!archerWrapper.isPresent()) {
            throw new UsernameNotFoundException("Email is not found");
        }
        authManager.authenticate(new UsernamePasswordAuthenticationToken(authInput.getEmail(), authInput.getPassword()));
        final String jwt = jwtService.generateToken(archerWrapper.get());
        return AuthResponse.builder().archer(archerWrapper.get()).accessToken(jwt).build();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String doLogout(String header) {
        final String accessToken = request.getHeader("Authorization").substring(7);
        log.info("Logging out from archery");
        BlackListToken blackListToken = new BlackListToken();
        blackListToken.setJwtToken(accessToken);
        final String email = jwtService.extractUsername(accessToken);
        blackListToken.setEmail(email);
        jwtService.disableToken(accessToken);
        return "Signed Out!";
    }

    @Override
    public Archer findById(Integer id) {
        log.info("Loading archer by id: {}", id);
        Optional<Archer> wrapper = archerService.loadById(id);
        return wrapper.orElse(null);
    }

}
