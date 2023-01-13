package Repositories;

import Models.Users.Roles.AbstractRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository<T extends AbstractRole> extends JpaRepository<T, Long> {
}
