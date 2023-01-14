package Models.Users.Roles;

import lombok.*;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class HeadRole extends AbstractRole {
    @Override
    public String getRoleType() {
        return "head";
    }

    {
        permissions = Set.of(
                Permissions.ReportPermission
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeadRole headRole = (HeadRole) o;
        return getRoleType() != null && Objects.equals(getRoleType(), headRole.getRoleType());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
