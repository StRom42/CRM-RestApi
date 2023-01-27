package com.crm.application.Utils.Auth;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class JwtUtils {

    public static JwtAuthentication generate(Claims claims) {
        final JwtAuthentication authentication = new JwtAuthentication();
        authentication.setLogin(claims.getSubject());
        authentication.setName(claims.get(JwtProvider.getClaimNameFieldName(), String.class));
        authentication.setAuthorities(getRoles(claims));
        return authentication;
    }

    private static Set<GrantedAuthority> getRoles(Claims claims) {
        final List<String> roles = claims.get(JwtProvider.getClaimRolesFieldName(), List.class);
        return roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
    }
}
