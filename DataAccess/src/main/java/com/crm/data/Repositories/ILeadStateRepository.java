package com.crm.data.Repositories;

import com.crm.data.Models.Lead.LeadState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILeadStateRepository extends JpaRepository<LeadState, String> {
}
