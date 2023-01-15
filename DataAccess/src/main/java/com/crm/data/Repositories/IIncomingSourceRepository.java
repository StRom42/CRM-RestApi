package com.crm.data.Repositories;

import com.crm.data.Models.Incomings.Sources.AbstractIncomingSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIncomingSourceRepository<T extends AbstractIncomingSource> extends JpaRepository<T, Long> {
}
