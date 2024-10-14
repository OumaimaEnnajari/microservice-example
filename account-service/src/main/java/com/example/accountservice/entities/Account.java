package com.example.accountservice.entities;

import com.example.accountservice.DTO.Customer;
import com.example.accountservice.enums.AccountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
public class Account {
    @Id
    private String accountId;
    private double balance;
    private LocalDate createdAt;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    @Transient  // to say to spring ignoring this attribute when mapping to Relational
    private Customer customer;  // we use it to populate
    @Column(nullable = false)
    private Long customerId;

}