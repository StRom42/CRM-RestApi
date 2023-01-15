package com.crm.data.Models.Incomings;

import com.crm.data.Models.Incomings.Sources.AbstractIncomingSource;
import com.crm.data.Models.Clients.Client;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@ToString
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AbstractIncomingSource getSource() {
        return source;
    }

    public void setSource(AbstractIncomingSource source) {
        this.source = source;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getIncomingType() {
        return incomingType;
    }

    public void setIncomingType(String incomingType) {
        this.incomingType = incomingType;
    }
}