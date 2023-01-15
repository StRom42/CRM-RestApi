package com.crm.data.Repositories;

import com.crm.data.Models.Incomings.AbstractIncoming;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIncomingRepository <T extends AbstractIncoming> extends JpaRepository<T, Long> {
}
