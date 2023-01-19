package com.crm.data.Models.Incomings.Sources;

import com.crm.data.Models.Devices.AbstractDevice;
import com.crm.data.Models.Incomings.AbstractIncoming;
import javax.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.Objects;

@AllArgsConstructor
@Entity
@ToString
@RequiredArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "sourceType", discriminatorType = DiscriminatorType.STRING)
@Table(name = "IncomingSource")
public abstract class AbstractIncomingSource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "device_id")
    private AbstractDevice device;

    @Column(name = "sourceType")
    public abstract String getSourceType();

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AbstractDevice getDevice() {
        return device;
    }

    public void setDevice(AbstractDevice device) {
        this.device = device;
    }

    public Collection<AbstractIncoming> getIncoming() {
        return incoming;
    }

    public void setIncoming(Collection<AbstractIncoming> incoming) {
        this.incoming = incoming;
    }
}
