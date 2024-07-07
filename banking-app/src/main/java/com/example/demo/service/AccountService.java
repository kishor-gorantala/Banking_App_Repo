package com.example.demo.service;


import com.example.demo.dto.AccountDto;
import com.example.demo.entity.Account;
import org.springframework.http.HttpStatusCode;

import java.util.List;

public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(Long id);

    AccountDto getAccountByName(String name);

    AccountDto Deposit(Long id, Double amount);

    AccountDto Withdraw(Long id, Double amount);

    List<AccountDto> getAllAccounts();

    void deleteAccountById(Long id);

}
