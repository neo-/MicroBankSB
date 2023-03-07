package com.naveejr.microbank.loans.controller;

import com.naveejr.microbank.loans.bo.Loan;
import com.naveejr.microbank.loans.dto.CustomerDTO;
import com.naveejr.microbank.loans.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor

@RestController
@RequestMapping
public class LoanController {
	private final LoanRepository loanRepository;

	@PostMapping("myLoans")
	public List<Loan> getLoanDetails(@RequestBody CustomerDTO customer) {
		return loanRepository.findByCustomerId(customer.id());
	}
}
