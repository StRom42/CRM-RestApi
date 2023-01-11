package Models.Clients;

import Models.Incomings.AbstractIncoming;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@RequiredArgsConstructor
@Table(name = "CLIENTS")
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    @Column
    public String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contactInfo_id")
    public ContactInfo contactInfo;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    public Set<AbstractIncoming> incoming = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id != null && Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
