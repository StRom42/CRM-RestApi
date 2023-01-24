package com.crm.data.Models.Lead;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "lead_states")
public class LeadState implements Serializable {
    @Id
    @Column(nullable = false)
    private String stateName;

    @Column(nullable = false)
    private Integer orderNumber;

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }
}
