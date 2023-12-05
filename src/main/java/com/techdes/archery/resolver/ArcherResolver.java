package com.techdes.archery.resolver;

import com.archery.packagename.types.AuthInput;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.techdes.archery.entity.Archer;
import com.techdes.archery.entity.enumeration.Role;
import com.techdes.archery.facade.ArcherFacade;
import com.techdes.archery.input.ArcherInput;
import com.techdes.archery.mapper.ArcherMapper;
import com.techdes.archery.response.AuthResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@DgsComponent
@AllArgsConstructor
@Slf4j
public class ArcherResolver {
    private final ArcherFacade archerFacade;
    private final HttpServletRequest request;
    @DgsMutation
    public AuthResponse register(@Valid ArcherInput archer) {
        log.info("Starting creating new archer in archery");
        return archerFacade.saveArcher(archer, ArcherMapper.INSTANCE::toArcher);
    }
    @DgsQuery
    public AuthResponse login(AuthInput authInput) {
        log.info("Starting signing in archery application");
        return archerFacade.doLogin(authInput);
    }
    @DgsMutation
    @PreAuthorize("hasAnyAuthority('ARCHER','ADMIN','RECORDER')")
    public String logout() {
        final String header = request.getHeader("Authorization");
        log.info("Signing out from archery with access token");
        return archerFacade.doLogout(header);
    }

    @DgsQuery
    @PreAuthorize("hasAnyAuthority('ARCHER','ADMIN','RECORDER')")
    public Archer getArcherById(Integer id) {
        log.info("Get archer by id: {}", id);
        return archerFacade.findById(id);
    }
}
