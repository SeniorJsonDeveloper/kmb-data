package com.kmbdata.dto;

import lombok.Data;

import java.util.List;

@Data
public class FinanceArticleJsonListDto {
    private List<FinanceArticleCreateDto> financeArticles;
}
