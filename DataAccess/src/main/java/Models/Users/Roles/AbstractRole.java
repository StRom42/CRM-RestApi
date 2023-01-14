package Models.Users.Roles;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "Roles")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "roleType", discriminatorType = DiscriminatorType.STRING)
public abstract class AbstractRole implements Serializable {
    @Id
    @Column(name = "roleType")
    public abstract String getRoleType();

    @Transient
    protected Set<GrantedAuthority> permissions = Collections.emptySet();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractRole that = (AbstractRole) o;
        return getRoleType() != null && Objects.equals(getRoleType(), getRoleType());
    }

    public Set<GrantedAuthority> getPermissions(){
        return permissions;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
