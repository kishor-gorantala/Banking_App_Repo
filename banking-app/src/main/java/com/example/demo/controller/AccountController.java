package com.example.demo.controller;

import com.example.demo.dto.AccountDto;
import com.example.demo.entity.Account;
import com.example.demo.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //Test String GET Method
    @GetMapping("/teststring")
    public String demo(){
        return "I am working fine, Ba-Bye";
    }

    //Test path variable returning Method
    @GetMapping("/returnname/{name}")
    public String demo1(@PathVariable String name){
        return "My name is " + name;
    }


    //Adding account REST API
    @PostMapping("/creation")
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    //Get account by ID REST API
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id) {
        AccountDto accountDto = accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }

    //Get account by Name
    @GetMapping("/name/{name}")
    public ResponseEntity<AccountDto> getAccountByName(@PathVariable String name) {
        AccountDto accountDto = accountService.getAccountByName(name);
        return ResponseEntity.ok(accountDto);
    }

    //Deposit Money to Account
    @PutMapping("/deposit/{id}")
    public ResponseEntity<AccountDto> Deposit(@PathVariable Long id, @RequestBody Map<String, Double> requestBody) {
        double amount = requestBody.get("amount");
        AccountDto accountDto = accountService.Deposit(id,amount);
        return ResponseEntity.ok(accountDto);
    }

    //Withdraw Money from Account
    @PutMapping("/withdraw/{id}")
    public ResponseEntity<AccountDto> Withdraw(@PathVariable Long id, @RequestBody Map<String, Double> requestBody){
        double amount = requestBody.get("amount");
        AccountDto accountDto = accountService.Withdraw(id,amount);
        return ResponseEntity.ok(accountDto);
    }

    //Get List of All Account
    @GetMapping("/getallaccounts")
    public List<AccountDto> getAllAccounts(){
        return accountService.getAllAccounts();
    }


    //Delete account by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> DeleteAccountById(@PathVariable Long id){
        accountService.deleteAccountById(id);
        return ResponseEntity.ok("Account is successfully deleted");
    }

}
