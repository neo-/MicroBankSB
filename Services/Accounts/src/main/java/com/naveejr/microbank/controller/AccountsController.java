package com.naveejr.microbank.controller;

import com.naveejr.microbank.bo.Accounts;
import com.naveejr.microbank.dto.Customer;
import com.naveejr.microbank.repository.AccountsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api/accounts")
public class AccountsController {

	private final AccountsRepository accountsRepository;

	@PostMapping("myAccount")
	public Accounts getAccountDetails(@RequestBody Customer customer) {
		return accountsRepository.findByCustomerId(customer.id());
	}

}
