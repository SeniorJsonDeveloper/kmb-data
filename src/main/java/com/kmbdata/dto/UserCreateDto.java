package com.kmbdata.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserCreateDto {
    private Integer id;
    private String username;
    private String password;

}
