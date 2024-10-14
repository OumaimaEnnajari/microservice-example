package com.example.accountservice.services;

import com.example.accountservice.DTO.Customer;
import com.example.accountservice.customers_DAO.ICustomerRepository;
import com.example.accountservice.entities.Account;
import com.example.accountservice.enums.AccountType;
import com.example.accountservice.repositories.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService{

    private AccountRepository accountRepository;
    private ICustomerRepository customerRepository;
    @Override
    public Account save(Account account) {
        account.setAccountId(UUID.randomUUID().toString());
        return accountRepository.save(account);
    }

    @Override
    public Customer getCustomer(Long id) {
        return customerRepository.findCustomerById(id);
    }

    @Override
    public String delete(String Id) {
        accountRepository.deleteById(Id);
        return Id;
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findById(String Id) {
        return accountRepository.findById(Id).orElse(null);
    }

    @Override
    public Account update(Map<String, Object> updates, String id) {

        Account account1= accountRepository.findById(id).orElse(null);
        if(account1!=null) {
            updates.forEach((key, value)-> {
                switch (key) {
                    case "balance" : account1.setBalance((double) value);
                                    break;
                    case "accountType" : account1.setAccountType((AccountType)value);
                                         break;
                    case "customerId" : account1.setAccountId((String) value);
                                        break;
                }
            });

            return accountRepository.save(account1);
        }
        return null;
    }
}
