package Repositories;

import Models.Incomings.AbstractIncoming;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IIncomingRepository <T extends AbstractIncoming> extends JpaRepository<T, Long> {
}
