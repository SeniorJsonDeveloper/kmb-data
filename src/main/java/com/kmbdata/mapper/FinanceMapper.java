package com.kmbdata.mapper;

import com.kmbdata.dto.FinanceArticleCreateDto;
import com.kmbdata.dto.FinanceArticleOutDto;
import com.kmbdata.dto.FinanceArticleOutListDto;
import com.kmbdata.dto.FinanceArticleOutTreeDto;
import com.kmbdata.entity.FinanceArticleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FinanceMapper {
    @Mapping(target = "createdAt",ignore = true)
    @Mapping(target = "parentId",source = "parentId")
    FinanceArticleEntity toEntity(FinanceArticleCreateDto financeArticleCreateDto);
    List<FinanceArticleOutTreeDto> toTree(List<FinanceArticleEntity> financeList);
    List<FinanceArticleOutDto> toList(List<FinanceArticleEntity> financeTree);
    @Mapping(target = "createdAt",ignore = true)
    FinanceArticleOutDto toEntityId(FinanceArticleEntity financeArticleCreateDto);
}

