package com.naveejr.microbank.repository;

import com.naveejr.microbank.bo.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountsRepository extends JpaRepository<Accounts, Long> {


	Accounts findByCustomerId(Long id);
}
