package com.example.accountservice;

import com.example.accountservice.entities.Account;
import com.example.accountservice.enums.AccountType;
import com.example.accountservice.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication implements CommandLineRunner {

    @Autowired
    private AccountRepository accountRepository;
    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        List<Account> accounts= List.of(
            Account.builder()
                .accountId(UUID.randomUUID().toString())
                .accountType(AccountType.CURRENT_ACCOUNT)
                .balance(10D)
                .customerId(1L)
                .createdAt(LocalDate.now())
                .build(),

            Account.builder()
                .accountId(UUID.randomUUID().toString())
                .accountType(AccountType.CURRENT_ACCOUNT)
                .balance(10D)
                .customerId(2L)
                .createdAt(LocalDate.now())
                .build()
        );
        accountRepository.saveAll(accounts);
    }
}
