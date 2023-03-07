package com.naveejr.mcirobank.cards.controller;

import com.naveejr.mcirobank.cards.bo.Card;
import com.naveejr.mcirobank.cards.dto.CustomerDTO;
import com.naveejr.mcirobank.cards.repository.CardsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api/cards")
public class CardsController {

	private final CardsRepository cardsRepository;

	@PostMapping("myCards")
	public List<Card> getCardsDetails(@RequestBody CustomerDTO customerDTO) {
		return cardsRepository.findByCustomerId(customerDTO.id());
	}

}
