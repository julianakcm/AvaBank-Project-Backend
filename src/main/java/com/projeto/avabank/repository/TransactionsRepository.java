package com.projeto.avabank.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.avabank.model.Transactions;

public interface TransactionsRepository extends JpaRepository<Transactions, Long> {
	
	List <Transactions> findByAccountId(Long AccountId);
	
	List<Transactions> findByAccountIdAndDate(Long AccountId, LocalDate startDate, LocalDate endDate);

	List<Transactions> findBySourceAccountIdAndDateTimeBetween(Long accountId, LocalDateTime startDate,
			LocalDateTime endDate);

}
