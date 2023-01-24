package com.crm.data.Models.Users.Roles;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collections;
import java.util.Set;

@Entity
@DiscriminatorValue("observer")
public class ObserverRole extends AbstractRole {

    {
        roleType =  "observer";
    }

    @Transient
    @Override
    public Set<GrantedAuthority> getPermissions() {
        return Collections.emptySet();
    }
}
