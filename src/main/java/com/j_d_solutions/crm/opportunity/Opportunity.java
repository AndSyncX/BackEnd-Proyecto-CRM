package com.j_d_solutions.crm.opportunity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "opportunities")
public class Opportunity {
    private Integer idopportunity;
    private String title;
    @ManyToOne
    @JoinColumn(name = "idclient")
    private String status;
    private Double value;
    private Date due_date;
}
