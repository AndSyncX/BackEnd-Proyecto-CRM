package com.j_d_solutions.crm.user;

import lombok.Data;

@Data
public class UserDto {
    private Integer id;
    private String username;
    private String password;
    private String role;
}
