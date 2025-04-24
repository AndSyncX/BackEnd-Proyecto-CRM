package com.j_d_solutions.crm.task;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "tasks")
public class Task {
    private Integer idtask;
    private String title;
    @ManyToOne
    @JoinColumn(name = "idclient")
    private Integer idclient;
    private String type;
    private Date due_date;
    private String notes;
}
