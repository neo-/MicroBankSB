package com.naveejr.microbank.service.client;

import com.naveejr.microbank.dto.CustomerDTO;
import com.naveejr.microbank.dto.LoansDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "loans", path = "/api")
public interface LoansFeignClient {

	@PostMapping("myLoans")
	List<LoansDTO> getLoanDetails(@RequestBody CustomerDTO customer);
}
