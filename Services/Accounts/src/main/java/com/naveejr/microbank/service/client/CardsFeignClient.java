package com.naveejr.microbank.service.client;

import com.naveejr.microbank.dto.CardsDTO;
import com.naveejr.microbank.dto.CustomerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "cards", path = "/api")
public interface CardsFeignClient {

	@PostMapping("myCards")
	List<CardsDTO> getCardDetails(@RequestBody CustomerDTO customer);
}
