package com.kmbdata.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FinanceArticleOutDto {
    private Integer id;
    private String title;
    private LocalDateTime createdAt = LocalDateTime.now();

}
