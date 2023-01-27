package com.crm.web.Utils;

import com.crm.application.Dto.AuthResponseDto;
import com.crm.application.Utils.Auth.JwtAuthentication;
import com.crm.application.Utils.Auth.JwtProvider;
import com.crm.application.Utils.Auth.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


public class AuthTokenFilter extends GenericFilterBean {
    public static final String AUTH_HEADER = "JWT_AUTH";
    @Autowired
    private JwtProvider tokenUtils;

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain
    ) throws IOException, ServletException {
        final String token = extractToken((HttpServletRequest) request);
        if (token != null && tokenUtils.validateAccessToken(token)) {
            final Claims claims = tokenUtils.getAccessClaims(token);
            final JwtAuthentication jwtInfoToken = JwtUtils.generate(claims);
            jwtInfoToken.setAuthenticated(true);
            SecurityContextHolder.getContext().setAuthentication(jwtInfoToken);
        }
        chain.doFilter(request, response);
    }

    private String extractToken(HttpServletRequest request) {
        final String bearer = request.getHeader(AUTH_HEADER);
        if (StringUtils.hasText(bearer) && bearer.startsWith(AuthResponseDto.type)) {
            return bearer.substring(AuthResponseDto.type.length());
        }
        return null;
    }
}
