package Models.Users.Roles;

import Models.Users.User;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "Roles")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "roleType", discriminatorType = DiscriminatorType.STRING)
public class AbstractRole implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "roleType")
    protected String roleType;

    @Column
    public boolean isReplyingPermitted() {
        return false;
    }

    @Column
    public boolean isReportingPermitted() {
        return false;
    }

    @Column
    public boolean isConfiguringPermitted() {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractRole that = (AbstractRole) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
