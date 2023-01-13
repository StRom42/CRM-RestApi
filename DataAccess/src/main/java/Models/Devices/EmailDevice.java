package Models.Devices;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Getter
@ToString
@RequiredArgsConstructor
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "emailDevices")
public class EmailDevice extends AbstractDevice{
    @Column
    private String host;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private Long port;
    @Column
    private String protocol;

    {
        setDeviceType("emailDevice");
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
