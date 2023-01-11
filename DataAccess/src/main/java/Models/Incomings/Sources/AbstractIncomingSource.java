package Models.Incomings.Sources;

import Models.Devices.AbstractDevice;
import Models.Incomings.AbstractIncoming;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@RequiredArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "sourceType", discriminatorType = DiscriminatorType.STRING)
@Table(name = "IncomingSource")
public class AbstractIncomingSource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "device_id")
    public AbstractDevice device;

    @Column(name = "sourceType")
    public String sourceType;

    @OneToMany(mappedBy = "source", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    public Collection<AbstractIncoming> incoming;

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
