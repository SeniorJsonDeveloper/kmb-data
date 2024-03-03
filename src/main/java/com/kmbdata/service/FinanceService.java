package com.kmbdata.service;

import com.kmbdata.dto.FinanceArticleCreateDto;
import com.kmbdata.dto.FinanceArticleJsonListDto;
import com.kmbdata.dto.FinanceArticleOutDto;
import com.kmbdata.entity.FinanceArticleEntity;

import java.util.List;

public interface FinanceService {
    List<FinanceArticleEntity> getFinanceList();
    FinanceArticleEntity getFinanceArticleById(Integer id);
    FinanceArticleOutDto createFinanceArticle(FinanceArticleCreateDto financeArticleCreateDto);
    void deleteFinanceArticleById(Integer id);
    void saveArticleList(FinanceArticleJsonListDto financeArticleJsonListDto);
}
