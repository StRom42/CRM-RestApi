package com.crm.data.Repositories;

import com.crm.data.Models.Reports.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReportRepository extends JpaRepository<Report, Long> {
}
