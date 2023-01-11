package Models.Incomings;

import Models.Clients.Client;
import Models.Incomings.Sources.AbstractIncomingSource;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@ToString
@RequiredArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class AbstractIncoming {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "incomingSource_id")
    @ToString.Exclude
    public AbstractIncomingSource source;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    @ToString.Exclude
    public Client client;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractIncoming that = (AbstractIncoming) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}