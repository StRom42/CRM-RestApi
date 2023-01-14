package Config;

import Models.Users.Roles.Permissions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception{
        http
                .cors().and().csrf().disable()
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/", "/login/**", "/error/**").permitAll()
                        .requestMatchers("/messages**").hasAuthority(Permissions.ReplyPermission.name())
                        .requestMatchers("/reports**").hasAuthority(Permissions.ReportPermission.name())
                        .requestMatchers("/admin**").hasRole("admin")
                );

        return http.build();
    }
}
