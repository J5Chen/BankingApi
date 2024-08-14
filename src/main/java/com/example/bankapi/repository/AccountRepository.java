package com.example.bankapi.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.bankapi.dtos.AccountDTO;

@Repository
public class AccountRepository {
	private Map<Integer, AccountDTO> accounts = new HashMap<>();
	
	public AccountDTO save(AccountDTO acc) {
		accounts.put(acc.getUserID(), acc);
		return acc;
	}
	
	public List<AccountDTO> findAll() {
		return new ArrayList<>(accounts.values());
	}
	
	public Optional<AccountDTO> findById(Integer accId) {
		return Optional.ofNullable(accounts.get(accId));
	}
}
