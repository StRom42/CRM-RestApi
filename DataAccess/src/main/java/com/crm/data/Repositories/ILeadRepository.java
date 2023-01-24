package com.crm.data.Repositories;

import com.crm.data.Models.Lead.Lead;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILeadRepository extends JpaRepository<Lead, Long> {
}
