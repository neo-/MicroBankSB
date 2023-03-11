package com.naveejr.microbank.dto;

import java.time.LocalDate;


public record LoansDTO(Long loanNumber, Long customerId, LocalDate createdAt, String loanType, int amountPaid,
                       int outstandingAmount, LocalDate startAt) {
}
