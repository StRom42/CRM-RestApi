package com.crm.data.Models.Incomings.Sources;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
@ToString
@RequiredArgsConstructor
@DiscriminatorValue("emailSource")
public class EmailIncomingSource extends AbstractIncomingSource{
    @Override
    public String getSourceType() {
        return "emailSource";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailIncomingSource that = (EmailIncomingSource) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
