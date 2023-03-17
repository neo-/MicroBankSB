package com.naveejr.microbank.service.client;

import com.naveejr.microbank.dto.CardsDTO;
import com.naveejr.microbank.dto.CustomerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "cards", path = "/api")
public interface CardsFeignClient {

	@PostMapping("myCards")
	List<CardsDTO> getCardDetails(@RequestHeader("microbank-correlation-id") String correlationId,
			@RequestBody CustomerDTO customer);
}
