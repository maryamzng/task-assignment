package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
public class ExpenseInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String expenseTitle;

    @ManyToOne(fetch = FetchType.LAZY)
    private BudgetInfo usedBudget;
    private Date expenseDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private AccountInfo usedAccount;
    private BigDecimal expenseAmount;

}
