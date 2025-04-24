package com.j_d_solutions.crm.client;

import lombok.Data;

@Data
public class ClientDto {
    private Integer idclient;
    private String name;
    private String company;
    private String email;
    private String phone;
    private String notes;
    private Integer iduser;
}
