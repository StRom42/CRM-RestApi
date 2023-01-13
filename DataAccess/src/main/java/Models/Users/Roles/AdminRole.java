package Models.Users.Roles;

import lombok.*;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@DiscriminatorValue(value = "admin")
public class AdminRole extends AbstractRole{
    @Override
    public boolean isConfiguringPermitted() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminRole adminRole = (AdminRole) o;
        return getId() != null && Objects.equals(getId(), adminRole.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
