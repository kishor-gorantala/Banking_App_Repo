package com.example.demo.controller;

import com.example.demo.dto.AccountDto;
import com.example.demo.service.AccountService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //String returning Method
    @GetMapping("/teststring")
    public ResponseEntity<String> demo(HttpServletRequest request){
        return new ResponseEntity("The session ID is "+request.getSession().getId(), HttpStatus.OK);
    }

    @GetMapping("/csrf_token")
    public CsrfToken csrftoken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    //path variable returning Method
    @GetMapping("/returnname/{name}")
    public String demo1(@PathVariable String name){
        return "My name is " + name;
    }

    //RequestParam returning Method
    @GetMapping("/Paramtesting")
    public String demo2(@RequestParam String param){
        return "Parameter is " + param;
    }

    //Creating account REST API
    @PostMapping("/creation")
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) {
        AccountDto accountDto1 = accountService.createAccount(accountDto);
        URI url = ServletUriComponentsBuilder.fromUriString("http://localhost:8080/api/accounts").path("/{id}").buildAndExpand(accountDto1.getId()).toUri();
        return ResponseEntity.created(url).build();
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
