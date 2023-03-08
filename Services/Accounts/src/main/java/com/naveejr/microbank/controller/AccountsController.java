package com.naveejr.microbank.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.naveejr.microbank.bo.Account;
import com.naveejr.microbank.config.AccountServiceConfig;
import com.naveejr.microbank.dto.CustomerDTO;
import com.naveejr.microbank.dto.Properties;
import com.naveejr.microbank.repository.AccountsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor

@RestController
@RequestMapping("/api/accounts")
public class AccountsController {

	private final AccountsRepository accountsRepository;

	private final AccountServiceConfig accountServiceConfig;

	@PostMapping("myAccount")
	public Account getAccountDetails(@RequestBody CustomerDTO customerDTO) {
		return accountsRepository.findByCustomerId(customerDTO.id());
	}

	@GetMapping("properties")
	public String getPropertyDetails() throws JsonProcessingException {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		Properties properties = new Properties(accountServiceConfig.getMsg(), accountServiceConfig.getBuildVersion(),
				accountServiceConfig.getMailDetails(), accountServiceConfig.getActiveBranches());
		return ow.writeValueAsString(properties);
	}

}
