package Models.Incomings.Sources;

import lombok.*;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import java.util.Objects;

@Entity
@DiscriminatorValue(value = "messengerSource")
@ToString
@RequiredArgsConstructor
public class MessengerIncomingSource extends AbstractIncomingSource{
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessengerIncomingSource that = (MessengerIncomingSource) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
