package com.crm.data.Models.Users.Roles;

import javax.persistence.DiscriminatorValue;
import lombok.*;

import javax.persistence.Entity;

import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@DiscriminatorValue("admin")
public class AdminRole extends AbstractRole{
    {
        roleType = "admin";
        permissions = Set.of(
                Permissions.ConfigurationPermission,
                Permissions.ReplyPermission,
                Permissions.ReportPermission
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminRole adminRole = (AdminRole) o;
        return getRoleType() != null && Objects.equals(getRoleType(), adminRole.getRoleType());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
