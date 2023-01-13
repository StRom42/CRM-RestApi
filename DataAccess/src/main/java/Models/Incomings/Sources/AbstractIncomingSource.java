package Models.Incomings.Sources;

import Models.Devices.AbstractDevice;
import Models.Incomings.AbstractIncoming;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "sourceType", discriminatorType = DiscriminatorType.STRING)
@Table(name = "IncomingSource")
public class AbstractIncomingSource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "device_id")
    private AbstractDevice device;

    @Column(name = "sourceType")
    protected String sourceType;

    @OneToMany(mappedBy = "source", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    private Collection<AbstractIncoming> incoming;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractIncomingSource that = (AbstractIncomingSource) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
