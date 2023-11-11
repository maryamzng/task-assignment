package com.example.demo.Dto;

import com.example.demo.entity.AccountInfo;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class AccountInfoDto {

    private String accountNo;
    private String accountName;
    private BigDecimal accountBalance;



    public static AccountInfo toEntity(AccountInfoDto accountInfoDto) {
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setAccountNo(accountInfoDto.getAccountNo());
        accountInfo.setAccountBalance(accountInfoDto.getAccountBalance());
        accountInfo.setAccountName(accountInfoDto.getAccountName());
        return accountInfo;

    }

    public static AccountInfoDto toDto(AccountInfo accountInfo) {
        AccountInfoDto accountInfoDto = new AccountInfoDto();
        accountInfoDto.setAccountNo(accountInfo.getAccountNo());
        accountInfoDto.setAccountBalance(accountInfo.getAccountBalance());
        accountInfoDto.setAccountName(accountInfo.getAccountName());
        return accountInfoDto;

    }
}
