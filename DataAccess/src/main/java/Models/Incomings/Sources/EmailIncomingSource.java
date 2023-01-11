package Models.Incomings.Sources;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
@DiscriminatorValue(value = "emailSource")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class EmailIncomingSource extends AbstractIncomingSource{
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailIncomingSource that = (EmailIncomingSource) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
