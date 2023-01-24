package com.crm.data.Models.Users.Roles;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

@ToString
@Entity
@Table(name = "roles")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_of_role", discriminatorType = DiscriminatorType.STRING)
public abstract class AbstractRole implements Serializable {
    @Id
    @Column(name = "roleTypeId", nullable = false)
    protected String roleType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractRole that = (AbstractRole) o;
        return getRoleType() != null && Objects.equals(getRoleType(), getRoleType());
    }

    @Transient
    public abstract Set<GrantedAuthority> getPermissions();

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public String getRoleType() {
        return roleType;
    }
}
