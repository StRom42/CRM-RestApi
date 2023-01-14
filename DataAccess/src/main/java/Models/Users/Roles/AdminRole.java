package Models.Users.Roles;

import lombok.*;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class AdminRole extends AbstractRole{
    {
        permissions = Set.of(
                Permissions.ConfigurationPermission,
                Permissions.ReplyPermission,
                Permissions.ReportPermission
        );
    }


    @Override
    public String getRoleType() {
        return "admin";
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
