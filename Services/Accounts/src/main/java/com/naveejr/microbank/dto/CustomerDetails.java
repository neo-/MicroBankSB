package com.naveejr.microbank.dto;

import com.naveejr.microbank.bo.Account;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


public record CustomerDetails(CustomerDTO customerDTO, Account account, List<CardsDTO> cards, List<LoansDTO> loans) {

}
