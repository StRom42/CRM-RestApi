package com.crm.data.Models.Reports;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "report_templates")
public class ReportTemplate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Lob
    @Column(nullable = false, columnDefinition = "TEXT")
    private byte[] templateData;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getTemplateData() {
        return templateData;
    }

    public void setTemplateData(byte[] templateData) {
        this.templateData = templateData;
    }
}
