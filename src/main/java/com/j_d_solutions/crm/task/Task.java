package com.j_d_solutions.crm.task;

import com.j_d_solutions.crm.client.Client;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idtask;
    private String title;
    @ManyToOne
    @JoinColumn(name = "idclient")
    private Client client;
    private String type;
    private Date due_date;
    private String notes;
}
