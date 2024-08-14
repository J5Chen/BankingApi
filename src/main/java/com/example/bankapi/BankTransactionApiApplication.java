package com.example.bankapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.bankapi.dtos.AccountDTO;


@SpringBootApplication
public class BankTransactionApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankTransactionApiApplication.class, args);
	}

}
