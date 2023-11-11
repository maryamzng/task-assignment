package com.example.demo.Dto;

import com.example.demo.entity.AccountInfo;
import com.example.demo.entity.BudgetInfo;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import lombok.Data;


import java.math.BigDecimal;
import java.util.Date;

@Data
public class ExpenseInfoDto {

    private String expenseTitle;

    @JsonIncludeProperties({"budgetName", "budgetCapAmount"})
    private BudgetInfo usedBudget;
    private Date expenseDate;
    @JsonIncludeProperties({"accountNo"})
    private AccountInfo usedAccount;
    private BigDecimal expenseAmount;
}
