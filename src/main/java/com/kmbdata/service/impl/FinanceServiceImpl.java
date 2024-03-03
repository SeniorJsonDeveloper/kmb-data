package com.kmbdata.service.impl;

import com.kmbdata.dto.FinanceArticleCreateDto;
import com.kmbdata.dto.FinanceArticleJsonListDto;
import com.kmbdata.dto.FinanceArticleOutDto;
import com.kmbdata.entity.FinanceArticleEntity;
import com.kmbdata.exception.NotFoundException;
import com.kmbdata.mapper.FinanceMapper;
import com.kmbdata.repository.FinanceArticleRepository;
import com.kmbdata.service.FinanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FinanceServiceImpl implements FinanceService  {
    private final FinanceArticleRepository financeArticleRepository;
    private final FinanceMapper financeMapper;

    @Override
    public List<FinanceArticleEntity> getFinanceList() {
        return financeArticleRepository.findAll();
    }

    @Override
    public FinanceArticleEntity getFinanceArticleById(Integer id) {
        return financeArticleRepository.findById(id)
                .orElseThrow(()->new NotFoundException(
                        MessageFormat.format("FinanceArticle with id: {0} not found!",id)
                ));
    }

    @Override
    public FinanceArticleOutDto createFinanceArticle(FinanceArticleCreateDto financeArticleCreateDto) {
        FinanceArticleEntity financeArticle = new FinanceArticleEntity();
        financeArticle.setId(financeArticleCreateDto.getId());
        financeArticle.setTitle(financeArticleCreateDto.getTitle());
        financeArticle.setParentId(financeArticle.getParentId());
        financeArticle.setCreatedAt(LocalDateTime.now());
        financeArticleRepository.save(financeArticle);
        FinanceArticleOutDto financeArticleOutDto = new FinanceArticleOutDto();
        financeArticleOutDto.setId(financeArticle.getId());
        financeArticleOutDto.setTitle(financeArticle.getTitle());
        financeArticleOutDto.setCreatedAt(financeArticle.getCreatedAt());
        return financeArticleOutDto;
    }

    @Override
    public void deleteFinanceArticleById(Integer id) {
        FinanceArticleEntity financeArticle = financeArticleRepository.findById(id)
                .orElseThrow(()->new NotFoundException(
                        MessageFormat.format("FinanceArticle with id: {0} not found!",id)
                ));
        financeArticleRepository.deleteById(id);


    }

    @Override
    public void saveArticleList(FinanceArticleJsonListDto financeArticleJsonListDto) {
        List<FinanceArticleEntity> financeArticleEntities = financeArticleJsonListDto.getFinanceArticles()
                .stream().map(financeMapper::toEntity).toList();
        financeArticleRepository.saveAll(financeArticleEntities);
    }
}
