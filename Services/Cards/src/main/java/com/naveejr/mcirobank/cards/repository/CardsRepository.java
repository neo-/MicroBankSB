package com.naveejr.mcirobank.cards.repository;

import com.naveejr.mcirobank.cards.bo.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardsRepository extends JpaRepository<Card, Long> {


	List<Card> findByCustomerId(Long id);
}
