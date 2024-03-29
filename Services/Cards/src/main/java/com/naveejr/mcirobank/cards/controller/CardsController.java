package com.naveejr.mcirobank.cards.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.naveejr.mcirobank.cards.bo.Card;
import com.naveejr.mcirobank.cards.config.CardsServiceConfig;
import com.naveejr.mcirobank.cards.dto.CustomerDTO;
import com.naveejr.mcirobank.cards.dto.Properties;
import com.naveejr.mcirobank.cards.repository.CardsRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api")
public class CardsController {

	private static final Logger log = LoggerFactory.getLogger(CardsController.class);
	private final CardsRepository cardsRepository;

	private final CardsServiceConfig cardsServiceConfig;

	@PostMapping("myCards")
	public List<Card> getCardsDetails(@RequestBody CustomerDTO customerDTO) {
		log.info("Getting Cards Details {} ", customerDTO);
		return cardsRepository.findByCustomerId(customerDTO.id());
	}


	@GetMapping("properties")
	public String getPropertyDetails() throws JsonProcessingException {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		Properties properties = new Properties(cardsServiceConfig.getMsg(), cardsServiceConfig.getBuildVersion(),
				cardsServiceConfig.getMailDetails(), cardsServiceConfig.getActiveBranches());
		return ow.writeValueAsString(properties);
	}

}
