package com.crm.data.Models.Users.Roles;

import javax.persistence.*;

@Entity
@DiscriminatorValue("observer")
public class ObserverRole extends AbstractRole {
    {
        roleType = "observer";
    }
}
