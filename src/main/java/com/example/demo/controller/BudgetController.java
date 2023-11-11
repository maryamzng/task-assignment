package com.example.demo.controller;


import com.example.demo.Dto.BudgetInfoDto;
import com.example.demo.service.BudgetInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/budget")
@RequiredArgsConstructor
public class BudgetController {

    private final BudgetInfoService budgetInfoService;

    @PostMapping
    public BudgetInfoDto save(@RequestBody BudgetInfoDto budgetInfoDto){
        return BudgetInfoDto.toDto(budgetInfoService.save(budgetInfoDto)) ;
    }

}
