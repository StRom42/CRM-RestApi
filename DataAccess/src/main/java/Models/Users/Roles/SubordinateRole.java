package Models.Users.Roles;

import lombok.*;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@DiscriminatorValue(value = "subordinate")
public class SubordinateRole extends AbstractRole{
    @Override
    public boolean isReplyingPermitted() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubordinateRole that = (SubordinateRole) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
