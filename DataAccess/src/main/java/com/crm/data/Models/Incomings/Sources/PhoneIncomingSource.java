package com.crm.data.Models.Incomings.Sources;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@ToString
@RequiredArgsConstructor
@DiscriminatorValue("phoneSource")
public class PhoneIncomingSource extends AbstractIncomingSource{
    @Override
    public String getSourceType() {
        return "phoneSource";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneIncomingSource that = (PhoneIncomingSource) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
