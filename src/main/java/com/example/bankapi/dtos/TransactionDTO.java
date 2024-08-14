package com.example.bankapi.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

public class TransactionDTO {
	private static int id = 0;
	
	private final int transactionID;
	private final LocalDateTime timestamp;
	@NotNull(message = "Sender Id can't be Null")
	private Integer senderId;  
	@NotNull(message = "Recipient Id can't be Null")
	private Integer recipientId; 
	@DecimalMin(value = "0.01", message = "Invalid Transfer Amount")
	private BigDecimal amount;
	
	public TransactionDTO(Integer senderId, Integer recipientId, BigDecimal amount) {
		this.transactionID = id++;
		this.senderId = senderId;
		this.recipientId = recipientId;
		this.amount = amount;
		this.timestamp = LocalDateTime.now();
	}

	public Integer getSenderId() {
		return senderId;
	}

	public void setSenderId(Integer senderId) {
		this.senderId = senderId;
	}

	public Integer getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(Integer recipientId) {
		this.recipientId = recipientId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public int getTransactionID() {
		return transactionID;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	
}
