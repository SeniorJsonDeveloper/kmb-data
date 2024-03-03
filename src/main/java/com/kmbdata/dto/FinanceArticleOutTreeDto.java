package com.kmbdata.dto;

import com.kmbdata.entity.FinanceArticleEntity;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class FinanceArticleOutTreeDto {
    private Integer id;
    private String title;
    private List<FinanceArticleEntity> finances = new ArrayList<>();
    private LocalDateTime createdAt = LocalDateTime.now();
}
