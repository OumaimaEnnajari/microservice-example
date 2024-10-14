package com.example.accountservice.services;

import com.example.accountservice.AccountServiceApplication;
import com.example.accountservice.DTO.Customer;
import com.example.accountservice.entities.Account;

import java.util.List;
import java.util.Map;

public interface IAccountService {
    Account save(Account account);
    String  delete(String Id);
    List<Account> findAll();
    Account findById(String Id);
    Account update(Map<String, Object> updates, String id);
    Customer getCustomer(Long id);

}
