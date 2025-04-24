package com.j_d_solutions.crm.opportunity;

import lombok.Data;

import java.util.Date;
@Data
public class OpportunityDto {
    private Integer idopportunity;
    private String title;
    private Integer idclient;
    private String status;
    private Double value;
    private Date due_date;
}
