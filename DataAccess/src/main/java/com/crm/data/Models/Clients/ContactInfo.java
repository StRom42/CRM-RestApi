package com.crm.data.Models.Clients;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@RequiredArgsConstructor
@Embeddable
public class ContactInfo implements Serializable {
    @Column
    private String email;
    @Column
    private String phoneNumber;
    @Column
    private String telegramNickname;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactInfo that = (ContactInfo) o;
        return Objects.equals(email, that.email) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(telegramNickname, that.telegramNickname);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTelegramNickname() {
        return telegramNickname;
    }

    public void setTelegramNickname(String telegramNickname) {
        this.telegramNickname = telegramNickname;
    }
}
