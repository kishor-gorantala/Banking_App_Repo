package com.example.demo.repository;

import com.example.demo.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.ExceptionHandler;


public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query(value = "SELECT * from accounts where account_holder_name=?", nativeQuery = true)
    @ExceptionHandler
    public Account findByName(String name);

}
