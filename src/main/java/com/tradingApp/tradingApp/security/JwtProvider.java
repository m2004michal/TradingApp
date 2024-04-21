package com.tradingApp.tradingApp.security;

import com.tradingApp.tradingApp.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JwtProvider {

    private final JwtEncoder jwtEncoder;
    @Value("${jwt.expiration.time}")
    private Long jwtExpirationInMillis;
    private final UserEntityRepository userEntityRepository;
    public String generateToken(Authentication authenticate) {
        User principal = (User) authenticate.getPrincipal();
        return generateTokenWithUsername(principal.getUsername());
    }


    public String generateTokenWithUsername(String username){
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(Instant.now())
                .expiresAt(Instant.now().plusMillis(jwtExpirationInMillis))
                .subject(username)
                .claim("scope", userEntityRepository.findByUsername(username)
                        .orElseThrow(() -> new RuntimeException("no username found"))
                        .getRole()
                        .getAuthorities()
                        .stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(" ")))
                .build();
        return this.jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

    public long getJwtExpirationInMillis() {
        return jwtExpirationInMillis;
    }
}
