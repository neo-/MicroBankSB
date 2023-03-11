package com.naveejr.microbank.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.naveejr.microbank.bo.Account;
import com.naveejr.microbank.config.AccountServiceConfig;
import com.naveejr.microbank.dto.*;
import com.naveejr.microbank.repository.AccountsRepository;
import com.naveejr.microbank.service.client.CardsFeignClient;
import com.naveejr.microbank.service.client.LoansFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor

@RestController
@RequestMapping("/api/accounts")
public class AccountsController {

	private final AccountsRepository accountsRepository;

	private final AccountServiceConfig accountServiceConfig;

	private final CardsFeignClient cardsFeignClient;
	private final LoansFeignClient loansFeignClient;

	@PostMapping("myAccount")
	public Account getAccountDetails(@RequestBody CustomerDTO customerDTO) {
		return accountsRepository.findByCustomerId(customerDTO.id());
	}

	@PostMapping("myCustomerDetails")
	public CustomerDetails getCustomerDetails(@RequestBody CustomerDTO customerDTO) {
		Account account = accountsRepository.findByCustomerId(customerDTO.id());
		List<CardsDTO> cards = cardsFeignClient.getCardDetails(customerDTO);
		List<LoansDTO> loans = loansFeignClient.getLoanDetails(customerDTO);
		return new CustomerDetails(customerDTO, account, cards, loans);

	}

	@GetMapping("properties")
	public String getPropertyDetails() throws JsonProcessingException {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		Properties properties = new Properties(accountServiceConfig.getMsg(), accountServiceConfig.getBuildVersion(),
				accountServiceConfig.getMailDetails(), accountServiceConfig.getActiveBranches());
		return ow.writeValueAsString(properties);
	}

}
