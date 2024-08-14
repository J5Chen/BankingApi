package com.example.bankapi.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.bankapi.dtos.TransactionDTO;

@Repository
public class TransactionRepository {
    private List<TransactionDTO> transactions = new ArrayList<>();

    public TransactionDTO save(TransactionDTO transaction) {
        transactions.add(transaction);
        return transaction;
    }
    
    public List<TransactionDTO> findAllTransactions() {
        return transactions;
    }

    public List<TransactionDTO> findByAccountId(Integer accountId) {
        return transactions.stream()
            .filter(t -> t.getSenderId().equals(accountId) || t.getRecipientId().equals(accountId))
            .collect(Collectors.toList());
    }
}