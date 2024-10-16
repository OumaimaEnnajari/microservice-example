package com.example.accountservice.controllers;

import com.example.accountservice.DTO.Customer;
import com.example.accountservice.customers_DAO.ICustomerRepository;
import com.example.accountservice.entities.Account;
import com.example.accountservice.services.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class AccountCotroller {
    private IAccountService accountService;


    @GetMapping("/accounts")
    public ResponseEntity<?> findAll() {
        List<Account> accounts= accountService.findAll();
        return new ResponseEntity<List<Account>>(accounts, HttpStatus.OK);
    }
    @PostMapping("/accounts")
    public ResponseEntity<?> save(Account account) {
        Account account1= accountService.save(account);
        return new ResponseEntity<Account>(account1, HttpStatus.OK);
    }

    @DeleteMapping("accounts/{id}")
    public ResponseEntity<?> delete(@PathVariable  String id) {
        accountService.delete(id);
        return new ResponseEntity<String>(id, HttpStatus.OK);
    }

    @PatchMapping("/accounts/{id}")
    public ResponseEntity<?> update(@RequestBody Map<String, Object> updates, @PathVariable String id) {
        Account account=accountService.update(updates, id);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @GetMapping("/accounts/{id}")
    public Account findById(@PathVariable String id) {
        Account account=accountService.findById(id);
        account.setCustomer(accountService.getCustomer(account.getCustomerId()));
        return account;
    }
    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable Long id) {
        Customer customer= accountService.getCustomer(id);
        return ResponseEntity.ok(customer);
    }
}
