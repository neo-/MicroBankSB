package com.naveejr.microbank.repository;

import com.naveejr.microbank.bo.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountsRepository extends JpaRepository<Account, Long> {


	Account findByCustomerId(Long id);
}
