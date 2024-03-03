package com.kmbdata.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FinanceArticleOutListDto {
    private List<FinanceArticleOutDto> finances = new ArrayList<>();

}
