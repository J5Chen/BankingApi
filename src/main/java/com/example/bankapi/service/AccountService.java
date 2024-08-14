package com.example.bankapi.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bankapi.dtos.AccountDTO;
import com.example.bankapi.dtos.TransactionDTO;
import com.example.bankapi.repository.AccountRepository;
import com.example.bankapi.repository.TransactionRepository;

@Service
public class AccountService {
	private final AccountRepository accountRepository;
	private final TransactionRepository transactionRepository;

	public AccountService(AccountRepository accountRepository, TransactionRepository transactionRepository) {
		this.accountRepository = accountRepository;
		this.transactionRepository = transactionRepository;
	}

	public AccountDTO createAccount(AccountDTO user) {
		return (accountRepository.save(user));
	}

	public AccountDTO getAccount(Integer id) {
		return accountRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Account not found"));
	}

	public List<AccountDTO> getAllAccounts() {
		return accountRepository.findAll();
	}

	public TransactionDTO transferFunds(TransactionDTO transaction) {

		Integer recipientId = transaction.getRecipientId();
		Integer senderId = transaction.getSenderId();

		AccountDTO recipient = accountRepository.findById(recipientId)
				.orElseThrow(() -> new IllegalArgumentException("Recipient not found"));
		AccountDTO sender = accountRepository.findById(senderId)
				.orElseThrow(() -> new IllegalArgumentException("Sender not found"));

		if (sender.getBalance().compareTo(transaction.getAmount()) < 0) {
			throw new IllegalArgumentException("Insufficient funds");
		}

		sender.decreaseBalance(transaction.getAmount());
		recipient.increaseBalance(transaction.getAmount());

		accountRepository.save(sender);
		accountRepository.save(recipient);

		return (transactionRepository.save(transaction));
	}

	public List<TransactionDTO> getAllTransactions() {
		return transactionRepository.findAllTransactions();
	}

	public List<TransactionDTO> getTransactionHistory(Integer accId) {
		return transactionRepository.findByAccountId(accId);
	}
}
