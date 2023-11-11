package com.example.demo.service;


import com.example.demo.Dto.AccountInfoDto;
import com.example.demo.entity.AccountInfo;
import com.example.demo.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.Dto.AccountInfoDto.toEntity;

@Service
@RequiredArgsConstructor
public class AccountService {

//    private final ModelMapper mapper;
    private final AccountRepository accountRepository;
//
//    public AccountInfo getAllAccount(String accountNo) {
//        return accountRepository.findByAccountNo(accountNo);
//
//    }

    public AccountInfo insertAccount(AccountInfoDto accountInfoDto) {
       return accountRepository.save(toEntity(accountInfoDto));

    }



}
