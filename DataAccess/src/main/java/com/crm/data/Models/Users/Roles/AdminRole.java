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
@DiscriminatorValue("admin")
public class AdminRole extends AbstractRole{
    {
        roleType = "admin";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminRole adminRole = (AdminRole) o;
        return getRoleType() != null && Objects.equals(getRoleType(), adminRole.getRoleType());
    }

    @Transient
    @Override
    public Set<GrantedAuthority> getPermissions() {
        return Set.of(
                Permissions.ConfigurationPermission,
                Permissions.ReplyPermission,
                Permissions.ReportPermission
        );
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
