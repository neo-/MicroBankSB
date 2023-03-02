package com.naveejr.microbank.bo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter

@Entity
@Table(name = "accounts")
public class Accounts {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long accountNumber;

	private Long customerId;

	private String accountType;
	private String branchAddress;
	private LocalDate createdAt;

}
