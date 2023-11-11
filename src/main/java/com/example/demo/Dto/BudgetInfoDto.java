package com.example.demo.Dto;

import com.example.demo.entity.BudgetInfo;
import lombok.Data;

import java.math.BigDecimal;


@Data
public class BudgetInfoDto {

    private String budgetName;
    private BigDecimal budgetCapAmount;

    public static BudgetInfoDto toDto(BudgetInfo budgetInfo){
        BudgetInfoDto budgetInfoDto = new BudgetInfoDto();
        budgetInfoDto.setBudgetName(budgetInfo.getBudgetName());
        budgetInfoDto.setBudgetCapAmount(budgetInfo.getBudgetCapAmount());
        return  budgetInfoDto;
    }

    public static BudgetInfo toEntity(BudgetInfoDto dto){

        BudgetInfo budgetInfo1 = new BudgetInfo();
        budgetInfo1.setBudgetName(dto.getBudgetName());
        budgetInfo1.setBudgetCapAmount(dto.getBudgetCapAmount());

        return budgetInfo1;
    }
}
