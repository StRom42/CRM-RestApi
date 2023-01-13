package Models.Incomings.Sources;

import lombok.*;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@ToString
@RequiredArgsConstructor
@DiscriminatorValue(value = "phoneSource")
public class PhoneIncomingSource extends AbstractIncomingSource{
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneIncomingSource that = (PhoneIncomingSource) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
