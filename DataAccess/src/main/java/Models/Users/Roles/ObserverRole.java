package Models.Users.Roles;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
public class ObserverRole extends AbstractRole {
    @Override
    public String getRoleType() {
        return "observer";
    }
}
