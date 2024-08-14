package com.example.bankapi.dtos;

import java.math.BigDecimal;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class AccountDTO {
	private static int id = 0;
	
	@NotNull(message = "User Id cannot be null")
	private final int userID;
	@NotNull(message = "First name Required")
	private String firstName;
	@NotNull(message = "Last name Required")
	private String lastName;
	private BigDecimal balance;
    
	public AccountDTO(String firstName, String lastName) {
		this.userID = id++;
		this.firstName = firstName;
		this.lastName = lastName;
        this.balance = BigDecimal.ZERO;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public int getUserID() {
		return userID;
	}
	
    public void increaseBalance(BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }

    public void decreaseBalance(BigDecimal amount) {
        this.balance = this.balance.subtract(amount);
    }
}
