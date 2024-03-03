package com.kmbdata.controller;

import com.kmbdata.dto.*;
import com.kmbdata.mapper.FinanceMapper;
import com.kmbdata.service.FinanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/finances")
@RequiredArgsConstructor
public class FinanceArticleController {
    private final FinanceService financeService;
    private final FinanceMapper financeMapper;
    @GetMapping("/{id}")
    public FinanceArticleOutDto getFinanceArticleById(@PathVariable Integer id){
       return financeMapper.toEntityId(financeService.getFinanceArticleById(id));
    }
    @GetMapping("/financeList")
    public List<FinanceArticleOutDto> getFinanceList(){
        return financeMapper.toList(financeService.getFinanceList());
    }
    @GetMapping("/financeTree")
    public List<FinanceArticleOutTreeDto> getFinanceTreeList(){
        return financeMapper.toTree(financeService.getFinanceList());
    }
    @PostMapping("/create")
    public FinanceArticleOutDto createFinanceArticle(@RequestBody FinanceArticleCreateDto financeArticleCreateDto){
       return  financeService.createFinanceArticle(financeArticleCreateDto);
    }
    @PostMapping("/save")
    public void saveArticle(@RequestBody FinanceArticleJsonListDto financeArticleJsonListDto){
        financeService.saveArticleList(financeArticleJsonListDto);
    }
    @DeleteMapping("/{id}")
    public void deleteFinanceArticleById(@PathVariable Integer id){
        financeService.deleteFinanceArticleById(id);
    }


}
