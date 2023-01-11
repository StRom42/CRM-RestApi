package Models.Devices;

import Models.Incomings.Sources.AbstractIncomingSource;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class AbstractDevice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @OneToOne(
            mappedBy = "device",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @ToString.Exclude
    public AbstractIncomingSource source;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractDevice that = (AbstractDevice) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
