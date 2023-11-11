package com.example.demo.service;


import com.example.demo.Dto.ExpenseInfoDto;
import com.example.demo.entity.AccountInfo;
import com.example.demo.entity.BudgetInfo;
import com.example.demo.entity.ExpenseInfo;
import com.example.demo.exception.IllegalTransactionException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.BudgetRepository;
import com.example.demo.repository.ExpenseInfoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpenseInfoService {

    private final ExpenseInfoRepository expenseInfoRepository;
    private final AccountRepository accountRepository;
    private final BudgetRepository budgetRepository;
    private final ModelMapper modelMapper;

    public ExpenseInfoDto save(ExpenseInfoDto dto) {
        AccountInfo accountInfo = accountRepository.findByAccountNo(dto.getUsedAccount().getAccountNo())
                .orElseThrow(()-> new ResourceNotFoundException("account", "accountNo", dto.getUsedAccount().getAccountNo()));

        BudgetInfo budgetInfo = budgetRepository.findByBudgetName(dto.getUsedBudget().getBudgetName())
                .orElseThrow(()-> new ResourceNotFoundException("budget", "budgetName", dto.getUsedBudget().getBudgetName()));

        if(dto.getExpenseAmount().compareTo(accountInfo.getAccountBalance())>0 ){
            throw new IllegalTransactionException( "account balance", dto.getUsedAccount().getAccountBalance());
        }

        if(dto.getExpenseAmount().compareTo(budgetInfo.getBudgetCapAmount())>0 ){
            throw new IllegalTransactionException( "budget cap", dto.getUsedBudget().getBudgetCapAmount());
        }

        accountInfo.setAccountBalance(accountInfo.getAccountBalance().subtract( dto.getExpenseAmount()));
        accountRepository.save(accountInfo);

        budgetInfo.setBudgetCapAmount(budgetInfo.getBudgetCapAmount().subtract(dto.getUsedBudget().getBudgetCapAmount()));
        budgetRepository.save(budgetInfo);


        ExpenseInfo expenseInfo = modelMapper.map(dto, ExpenseInfo.class);
        expenseInfo.setUsedAccount(accountInfo);
        expenseInfo.setUsedBudget(budgetInfo);

        return modelMapper.map(expenseInfoRepository.save(expenseInfo), ExpenseInfoDto.class);
    }

    public List<ExpenseInfoDto> getAllExpenseForAccount(String accountNo) {
        AccountInfo accountInfo = accountRepository.findByAccountNo(accountNo)
                .orElseThrow(()-> new ResourceNotFoundException("account", "accountNo",accountNo));

        List<ExpenseInfo> expenseInfoList = expenseInfoRepository.findByUsedAccount(accountInfo);

        return expenseInfoList.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());

    }
    public List<ExpenseInfoDto> getAllExpense(Date date){
        List<ExpenseInfo> expenseInfoList = expenseInfoRepository.findByExpenseDate(date);
        return expenseInfoList.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public List<ExpenseInfoDto> getAllExpenseByBudgetName(String budgetName){
        BudgetInfo budgetInfo = budgetRepository.findByBudgetName(budgetName)
                .orElseThrow(()-> new ResourceNotFoundException("budget", "budgetName", budgetName));

        List<ExpenseInfo> expenseInfoList = expenseInfoRepository.findByUsedBudget(budgetInfo);
        return expenseInfoList.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private ExpenseInfoDto mapToDto(ExpenseInfo expenseInfo) {
        return modelMapper.map(expenseInfo, ExpenseInfoDto.class);

    }

}
