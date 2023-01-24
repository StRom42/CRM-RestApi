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
@DiscriminatorValue("subordinate")
public class SubordinateRole extends AbstractRole{
    {
        roleType = "subordinate";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubordinateRole that = (SubordinateRole) o;
        return getRoleType() != null && Objects.equals(getRoleType(), that.getRoleType());
    }

    @Transient
    @Override
    public Set<GrantedAuthority> getPermissions() {
        return Set.of(
                Permissions.ReplyPermission
        );
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
