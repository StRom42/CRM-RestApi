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
@DiscriminatorValue("subordinate")
public class SubordinateRole extends AbstractRole{
    {
        roleType = "subordinate";
        permissions = Set.of(
                Permissions.ReplyPermission
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubordinateRole that = (SubordinateRole) o;
        return getRoleType() != null && Objects.equals(getRoleType(), that.getRoleType());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}