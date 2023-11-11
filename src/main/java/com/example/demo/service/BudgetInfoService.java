package com.example.demo.service;

import com.example.demo.Dto.BudgetInfoDto;
import com.example.demo.Dto.ExpenseInfoDto;
import com.example.demo.entity.BudgetInfo;
import com.example.demo.entity.ExpenseInfo;
import com.example.demo.repository.BudgetRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class BudgetInfoService {

    private final BudgetRepository budgetRepository;
    private final ModelMapper modelMapper;

    public BudgetInfo save(BudgetInfoDto dto){
       return budgetRepository.save(BudgetInfoDto.toEntity(dto));
    }
    private BudgetInfoDto mapToDto(BudgetInfo budgetInfo) {
        return modelMapper.map(budgetInfo, BudgetInfoDto.class);

    }
}
