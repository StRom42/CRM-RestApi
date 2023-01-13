package Models.Incomings;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Setter
@Getter
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
}
