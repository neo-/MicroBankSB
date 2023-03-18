package com.naveejr.microbank.loans.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.naveejr.microbank.loans.bo.Loan;
import com.naveejr.microbank.loans.config.LoansServiceConfig;
import com.naveejr.microbank.loans.dto.CustomerDTO;
import com.naveejr.microbank.loans.dto.Properties;
import com.naveejr.microbank.loans.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api")
public class LoanController {
	private static final Logger log = LoggerFactory.getLogger(LoanController.class);
	private final LoanRepository loanRepository;

	private final LoansServiceConfig loansServiceConfig;

	@PostMapping("myLoans")
	public List<Loan> getLoanDetails(@RequestBody CustomerDTO customer) {
		log.info("Getting Loan details {}", customer);
		return loanRepository.findByCustomerId(customer.id());
	}

	@GetMapping("properties")
	public String getPropertyDetails() throws JsonProcessingException {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		Properties properties = new Properties(loansServiceConfig.getMsg(), loansServiceConfig.getBuildVersion(),
				loansServiceConfig.getMailDetails(), loansServiceConfig.getActiveBranches());
		return ow.writeValueAsString(properties);
	}

}
