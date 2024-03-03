package com.kmbdata.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FinanceArticleCreateDto {
    private Integer id;
    private String title;
    private Integer parentId;
    private LocalDateTime createdAt;

}
