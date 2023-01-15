package com.crm.data.Models.Incomings.Sources;

import jakarta.persistence.Entity;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Objects;

@Entity
@ToString
@RequiredArgsConstructor
public class MessengerIncomingSource extends AbstractIncomingSource{
    @Override
    public String getSourceType() {
        return "messengerSource";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessengerIncomingSource that = (MessengerIncomingSource) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
