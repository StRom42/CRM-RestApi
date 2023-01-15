package com.crm.data.Models.Incomings;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "EmailMessages")
public class EmailMessageIncoming extends AbstractIncoming{
    @Lob
    private String content;

    @Column
    private String incomingEmail;

    {
        setIncomingType("emailMessage");
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIncomingEmail() {
        return incomingEmail;
    }

    public void setIncomingEmail(String incomingEmail) {
        this.incomingEmail = incomingEmail;
    }
}
