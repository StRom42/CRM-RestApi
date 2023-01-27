package com.crm.application.Utils.Auth;

import com.crm.data.Models.Users.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.io.Serializable;
import java.security.Key;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;


@Component
public class JwtProvider implements Serializable {
    private final SecretKey jwtAccessSecret;
    private final SecretKey jwtRefreshSecret;

    @Value("${restcrm.app.jwt.accessExpirationDays}")
    private Integer accessExpiryPeriod;

    @Value("${restcrm.app.jwt.refreshExpirationDays}")
    private Integer refreshExpiryPeriod;

    public JwtProvider(
            @Value("${restcrm.app.jwt.refresh_secret}") String jwtAccessSecret,
            @Value("${restcrm.app.jwt.access_secret}") String jwtRefreshSecret) {
        this.jwtAccessSecret = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtAccessSecret));
        this.jwtRefreshSecret = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtRefreshSecret));
    }

    public static String getClaimRolesFieldName() {
        return "roles";
    }

    public static String getClaimNameFieldName() {
        return "name";
    }

    public String generateAccessToken(User user) {
        final LocalDateTime now = LocalDateTime.now();
        final Instant accessExpirationInstant = now.plusDays(accessExpiryPeriod)
                .atZone(ZoneId.systemDefault()).toInstant();
        final Date accessExpiration = Date.from(accessExpirationInstant);
        return Jwts.builder()
                .setSubject(user.getLogin())
                .setExpiration(accessExpiration)
                .signWith(jwtAccessSecret)
                .claim(getClaimRolesFieldName(), user.getAuthorities())
                .claim(getClaimNameFieldName(), user.getName())
                .compact();
    }

    public String generateRefreshToken(User user) {
        final LocalDateTime now = LocalDateTime.now();
        final Instant accessExpirationInstant = now.plusDays(refreshExpiryPeriod)
                .atZone(ZoneId.systemDefault()).toInstant();
        final Date accessExpiration = Date.from(accessExpirationInstant);
        return Jwts.builder()
                .setSubject(user.getLogin())
                .setExpiration(accessExpiration)
                .signWith(jwtRefreshSecret)
                .compact();
    }

    public boolean validateAccessToken(String token) {
        return validateToken(token, jwtAccessSecret);
    }

    public boolean validateRefreshToken(String token) {
        return validateToken(token, jwtRefreshSecret);
    }

    public Claims getAccessClaims(String token) {
        return getClaims(token, jwtAccessSecret);
    }

    public Claims getRefreshClaims(String token) {
        return getClaims(token, jwtRefreshSecret);
    }

    private boolean validateToken(String token, Key secret) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(secret)
                    .build()
                    .parseClaimsJws(token);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    private Claims getClaims(String token, Key secret) {
        return Jwts.parserBuilder()
                .setSigningKey(secret)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

}
