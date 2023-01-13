package Models.Incomings;

import Models.Clients.Client;
import Models.Incomings.Sources.AbstractIncomingSource;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@ToString
@Getter
@Setter
@RequiredArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class AbstractIncoming {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "incomingSource_id")
    @ToString.Exclude
    private AbstractIncomingSource source;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    @ToString.Exclude
    private Client client;

    @Column
    protected String incomingType = getClass().getSimpleName();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractIncoming that = (AbstractIncoming) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}