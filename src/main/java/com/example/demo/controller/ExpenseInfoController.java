package com.example.demo.controller;


import com.example.demo.Dto.ExpenseInfoDto;
import com.example.demo.service.ExpenseInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/expense")
@RequiredArgsConstructor
public class ExpenseInfoController {

    private final ExpenseInfoService expenseInfoService;

    @PostMapping
    public ExpenseInfoDto save(@RequestBody ExpenseInfoDto dto){
        return expenseInfoService.save(dto);
    }
    @GetMapping("/account/{accountNo}")
    public List<ExpenseInfoDto> getAllExpenseByAccNo(@PathVariable String accountNo){
        return expenseInfoService.getAllExpenseForAccount(accountNo);
    }

    @GetMapping("/date/{date}")
    public List<ExpenseInfoDto> getAllExpense(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        return expenseInfoService.getAllExpense(date);
    }

    @GetMapping("/budget/{budgetName}")
    public List<ExpenseInfoDto> getAllExpenseByBudgetName(@PathVariable String budgetName){
        return expenseInfoService.getAllExpenseByBudgetName(budgetName);
    }

}
