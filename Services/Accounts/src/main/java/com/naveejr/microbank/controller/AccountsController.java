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
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@Slf4j

@RestController
@RequestMapping("/api")
public class AccountsController {

	private final AccountsRepository accountsRepository;

	private final AccountServiceConfig accountServiceConfig;

	private final CardsFeignClient cardsFeignClient;
	private final LoansFeignClient loansFeignClient;

	@GetMapping
	public ResponseEntity<String> health() {
		return ResponseEntity.ok("Health OK");
	}

	@PostMapping("myAccount")
	public Account getAccountDetails(@RequestBody CustomerDTO customerDTO) {
		log.info("Getting account details {}", customerDTO);
		return accountsRepository.findByCustomerId(customerDTO.id());
	}

	@PostMapping("myCustomerDetails")
	@CircuitBreaker(name = "detailsForCustomerSupportApp", fallbackMethod = "myCustomerDetailsFallback")
	public CustomerDetails getCustomerDetails(@RequestHeader("microbank-correlation-id") String correlationId,
			@RequestBody CustomerDTO customerDTO) {
		Account account = accountsRepository.findByCustomerId(customerDTO.id());
		List<CardsDTO> cards = cardsFeignClient.getCardDetails(correlationId, customerDTO);
		List<LoansDTO> loans = loansFeignClient.getLoanDetails(correlationId, customerDTO);
		return new CustomerDetails(customerDTO, account, cards, loans);
	}

	private CustomerDetails myCustomerDetailsFallback(@RequestHeader("microbank-correlation-id") String correlationId, CustomerDTO customerDTO, Throwable t) {
		log.error("Failed to connect to microservice ", t);
		Account account = accountsRepository.findByCustomerId(customerDTO.id());
		List<LoansDTO> loans = loansFeignClient.getLoanDetails(correlationId, customerDTO);
		return new CustomerDetails(customerDTO, account, null, loans);
	}

	@GetMapping("properties")
	public String getPropertyDetails() throws JsonProcessingException {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		Properties properties = new Properties(accountServiceConfig.getMsg(), accountServiceConfig.getBuildVersion(),
				accountServiceConfig.getMailDetails(), accountServiceConfig.getActiveBranches());
		return ow.writeValueAsString(properties);
	}

}
