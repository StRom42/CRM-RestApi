package com.crm.data.Models.Users.Roles;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("observer")
public class ObserverRole extends AbstractRole {
}
