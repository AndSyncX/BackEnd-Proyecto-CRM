package com.j_d_solutions.crm.client;

import com.j_d_solutions.crm.user.User;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idclient;
    private String name;
    private String company;
    private String email;
    private String phone;
    private String notes;

    @ManyToOne
    @JoinColumn(name = "iduser")
    private User user;
}
