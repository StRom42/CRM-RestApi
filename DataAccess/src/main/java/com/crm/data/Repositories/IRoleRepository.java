package com.crm.data.Repositories;

import com.crm.data.Models.Users.Roles.AbstractRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository<T extends AbstractRole> extends JpaRepository<T, Long> {
}
