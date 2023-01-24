package com.crm.data.Models.Users.Roles;

import javax.persistence.DiscriminatorValue;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.Objects;
import java.util.Set;

@Entity
@ToString
@DiscriminatorValue("head")
public class HeadRole extends AbstractRole {
    {
        roleType =  "head";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeadRole headRole = (HeadRole) o;
        return getRoleType() != null && Objects.equals(getRoleType(), headRole.getRoleType());
    }

    @Transient
    @Override
    public Set<GrantedAuthority> getPermissions() {
        return Set.of(
                Permissions.ReportPermission
        );
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
