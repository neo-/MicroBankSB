package com.naveejr.mcirobank.cards.bo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter

@Entity
@Table(name = "cards")
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cardId;

	private Long customerId;

	private String cardNumber;

	private String cardType;

	private int totalLimit;

	private int amountUsed;
	private int availableAmount;
	private LocalDate createdAt;

}
