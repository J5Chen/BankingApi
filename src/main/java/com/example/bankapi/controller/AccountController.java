package com.example.bankapi.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bankapi.dtos.AccountDTO;
import com.example.bankapi.dtos.TransactionDTO;
import com.example.bankapi.service.AccountService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class AccountController {
	@Autowired
	private AccountService accountService;

	@PostMapping("/accounts")
	public ResponseEntity<AccountDTO> createAccount(@Valid @RequestBody AccountDTO user) {
		AccountDTO createdAccount = accountService.createAccount(user);
		return ResponseEntity.ok(createdAccount);
	}
	
	@GetMapping("/accounts")
	public ResponseEntity<List<AccountDTO>> getAllAccounts() {
		List<AccountDTO> accounts = accountService.getAllAccounts();
		if (accounts.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(accounts);
	}
	
	@GetMapping("/accounts/{id}")
	public ResponseEntity<AccountDTO> getAccount(@PathVariable Integer id) {
		AccountDTO transactions = accountService.getAccount(id);
		return ResponseEntity.ok(transactions);
	}

	@PostMapping("/accounts/transfer")
	public ResponseEntity<TransactionDTO> transferFunds(@Valid @RequestBody TransactionDTO transaction) {
		accountService.transferFunds(transaction);
		return ResponseEntity.ok(transaction);
	}
	
	@GetMapping("/transactions")
	public ResponseEntity<List<TransactionDTO>> getAllTransactions() {
		List<TransactionDTO> transactions = accountService.getAllTransactions();
		if (transactions.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(transactions);
	}

	@GetMapping("/transactions/{id}")
	public ResponseEntity<List<TransactionDTO>> getTransactionHistory(@PathVariable Integer id) {
		List<TransactionDTO> transactions = accountService.getTransactionHistory(id);
		if (transactions.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(transactions);
	}
}