package com.crm.data.Repositories;

import com.crm.data.Models.Reports.ReportTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReportTemplateRepository extends JpaRepository<ReportTemplate, Long> {
}
