package com.techdes.archery.service.impl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.techdes.archery.entity.BlackListToken;
import com.techdes.archery.entity.QBlackListToken;
import com.techdes.archery.repository.BlackListTokenRepository;
import com.techdes.archery.service.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtServiceImpl extends BaseServiceImpl<Long, BlackListToken, BlackListTokenRepository> implements JwtService {
    private static String SECRET_KEY = "6D597133743677397A24432646294A404E635266546A576E5A72347537782141";
    protected JwtServiceImpl(BlackListTokenRepository repository) {
        super(repository);
    }

    @Override
    public String extractUsername(String jwtToken) {
        return extractClaim(jwtToken, Claims::getSubject);
    }

    @Override
    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(),userDetails);
    }

    @Override
    public String generateToken(Map<String, Object> extractClaims, UserDetails userDetails) {
        return Jwts
                .builder()
                .setClaims(extractClaims).setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                // Set Token expiration to 1 day
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256).compact();

    }
    @Override
    public Boolean isTokenValid(String jwtToken, UserDetails userDetails) {
        final String username = extractUsername(jwtToken);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(jwtToken) && !isBlackListToken(jwtToken);
    }

    @Override
    public Boolean isBlackListToken(String jwtToken) {
        BooleanExpression where = QBlackListToken.blackListToken.jwtToken.eq(jwtToken);
        return repository.exists(where);
    }

    @Override
    public Date extractExpiration(String jwtToken) {
        return extractClaim(jwtToken, Claims::getExpiration);
    }

    @Override
    public boolean isTokenExpired(String jwtToken) {
        return extractExpiration(jwtToken).before(new Date());
    }

    public <T> T extractClaim(String tokenKey, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(tokenKey);
        return claimsResolver.apply(claims);
    }

    @Override
    public void disableToken(String jwtToken) {
        BlackListToken token = new BlackListToken();
        String email = extractUsername(jwtToken);
        token.setJwtToken(jwtToken);
        token.setEmail(email);
        repository.save(token);
    }

    private Claims extractAllClaims(String tokenKey) {
        return Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(tokenKey).getBody();
    }

    private Key getSigningKey(){
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
