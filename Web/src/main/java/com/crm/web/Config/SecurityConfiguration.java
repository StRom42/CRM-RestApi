package com.crm.web.Config;

import com.crm.application.Contracts.IUserService;
import com.crm.data.Models.Users.Roles.Permissions;
import com.crm.web.Utils.AuthTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.security.SecureRandom;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private static final String[] AUTH_WHITELIST = {
            // -- Swagger UI v2
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            // -- Swagger UI v3 (OpenAPI)
            "/v3/api-docs/**",
            "/swagger-ui/**"
            // other public endpoints of your API may be appended to this array
    };

    @Autowired
    private IUserService userService;

    @Bean
    public PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder(8, new SecureRandom( ));
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public AuthTokenFilter tokenFilter() {
        return new AuthTokenFilter();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                    .antMatchers("/auth/signup").not().authenticated()
                    .antMatchers("/", "/health", "/version", "/auth/*", "/error**").permitAll()
                    .antMatchers(AUTH_WHITELIST).permitAll()
                    .antMatchers("/messages**").hasAuthority(Permissions.ReplyPermission.name())
                    .antMatchers("/reports**").hasAuthority(Permissions.ReportPermission.name())
                    .antMatchers("/admin**").hasRole("admin")
                    .anyRequest().authenticated()
                .and()
                .formLogin().disable()
                .cors().and().csrf().disable()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.NEVER);
        http.addFilterAfter(tokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
