package com.naveejr.microbank.loans.repository;

import com.naveejr.microbank.loans.bo.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {
	List<Loan> findByCustomerId(Long id);
}
