package com.techdes.archery.service;

import com.techdes.archery.entity.BlackListToken;
import io.jsonwebtoken.Claims;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@NoRepositoryBean
public interface JwtService extends BaseService<Long, BlackListToken> {
    String extractUsername(String tokenKey);
    String generateToken(UserDetails userDetails);
    String generateToken(Map<String, Object> extractClaims, UserDetails userDetails);
    Boolean isTokenValid(String jwtToken, UserDetails userDetails);
    Boolean isBlackListToken(String jwtToken);
    Date extractExpiration(String jwtToken);
    boolean isTokenExpired(String jwtToken);
    void disableToken(String jwtToken);
    <T> T extractClaim(String tokenKey, Function<Claims, T> claimsResolver);
}
