package com.example.demo.repository;

import com.example.demo.entity.BudgetInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BudgetRepository extends JpaRepository<BudgetInfo, Long> {
    Optional<BudgetInfo> findByBudgetName(String budgetName);
}
