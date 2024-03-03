package com.kmbdata.repository;

import com.kmbdata.entity.FinanceArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinanceArticleRepository extends JpaRepository<FinanceArticleEntity,Integer> {
}
