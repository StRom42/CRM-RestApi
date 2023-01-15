package com.crm.data.Models.Users.Roles;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "Roles")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_of_role", discriminatorType = DiscriminatorType.STRING)
public abstract class AbstractRole implements Serializable {
    @Id
    @Column(name = "type_of_role", insertable = false, updatable = false)
    public String roleType;

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

    public String getRoleType() {
        return roleType;
    }
}
