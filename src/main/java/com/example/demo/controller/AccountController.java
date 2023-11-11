package com.example.demo.controller;


import com.example.demo.Dto.AccountInfoDto;
import com.example.demo.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping()
    public AccountInfoDto insert(@RequestBody AccountInfoDto dto){
        return AccountInfoDto.toDto(accountService.insertAccount(dto));
    }
}
