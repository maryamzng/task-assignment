package com.example.demo.repository;

import com.example.demo.entity.AccountInfo;
import com.example.demo.entity.BudgetInfo;
import com.example.demo.entity.ExpenseInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ExpenseInfoRepository  extends JpaRepository<ExpenseInfo,Long> {

    List<ExpenseInfo> findByUsedAccount(AccountInfo accountInfo);
    List<ExpenseInfo> findByUsedBudget(BudgetInfo budgetInfo);
    List<ExpenseInfo> findByExpenseDate(Date date);
}
