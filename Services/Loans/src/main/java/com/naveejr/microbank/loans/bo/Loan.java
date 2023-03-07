package com.naveejr.microbank.loans.bo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter

@Entity
@Table(name = "loans")
public class Loan {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long loanNumber;
	private Long customerId;
	private LocalDate createdAt;
	private String loanType;
	private int amountPaid;
	private int outstandingAmount;
	private LocalDate startAt;
}
