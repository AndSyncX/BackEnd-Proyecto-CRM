package com.j_d_solutions.crm.task;

import lombok.Data;

import java.util.Date;
@Data
public class TaskDto {
    private Integer idtask;
    private String title;
    private Integer idclient;
    private String type;
    private Date due_date;
    private String notes;
}
