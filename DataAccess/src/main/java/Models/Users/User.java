package Models.Users;

import Models.Users.Roles.AbstractRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "USRS")
public class User implements Serializable, UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String login;
    private String password;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_type")
    private Set<AbstractRole> roles = new HashSet<>();


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> permissions = roles.stream()
                .map(AbstractRole::getPermissions)
                .flatMap(Set::stream)
                .collect(Collectors.toSet());
        Set<GrantedAuthority> role_names = roles.stream()
                .map(x -> new SimpleGrantedAuthority("ROLE_" + x.getRoleType()))
                .collect(Collectors.toSet());
        permissions.addAll(role_names);
        return permissions;
    }

    @Override
    public String getUsername() {
        return getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
