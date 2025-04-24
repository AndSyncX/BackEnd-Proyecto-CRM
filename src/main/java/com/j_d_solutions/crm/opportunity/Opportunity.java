package com.j_d_solutions.crm.opportunity;

import com.j_d_solutions.crm.client.Client;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "opportunities")
public class Opportunity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idopportunity;
    private String title;
    @ManyToOne
    @JoinColumn(name = "idclient")
    private Client client;
    private String status;
    private Double value;
    private Date due_date;
}
