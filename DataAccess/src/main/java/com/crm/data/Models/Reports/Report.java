package com.crm.data.Models.Reports;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "reports")
public abstract class Report implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(targetEntity = ReportTemplate.class)
    @JoinColumn(name = "report_to_template", nullable = false)
    private ReportTemplate template;

    @Lob
    @Column(nullable = false, columnDefinition = "bytea")
    private byte[] reportData;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
