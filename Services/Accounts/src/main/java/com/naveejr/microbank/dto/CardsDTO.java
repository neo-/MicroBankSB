package com.naveejr.microbank.dto;

import java.sql.Date;


public record CardsDTO(int cardId, int customerId, String cardNumber, String cardType, int totalLimit, int amountUsed,
                       int availableAmount, Date createDt) {
}
