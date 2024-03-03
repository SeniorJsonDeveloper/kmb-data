package com.kmbdata.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserOutDto {
    private Integer id;
    private String username;
    private LocalDateTime createdAt = LocalDateTime.now();
}
