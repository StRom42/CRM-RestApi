package Repositories;

import Models.Incomings.Sources.AbstractIncomingSource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IIncomingSourceRepository<T extends AbstractIncomingSource> extends JpaRepository<T, Long> {
}
