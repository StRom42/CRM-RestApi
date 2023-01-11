package Models.Incomings.Sources;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
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
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
