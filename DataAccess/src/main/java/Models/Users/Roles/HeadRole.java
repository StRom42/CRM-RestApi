package Models.Users.Roles;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@DiscriminatorValue(value = "head")
public class HeadRole extends AbstractRole {
    @Override
    public boolean isReportingPermitted() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeadRole headRole = (HeadRole) o;
        return getId() != null && Objects.equals(getId(), headRole.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
