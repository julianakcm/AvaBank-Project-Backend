package com.projeto.avabank.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.avabank.model.InvestmentTransactions;

public interface InvestmentTransactionsRepository extends JpaRepository<InvestmentTransactions, Long> {
	
	List<InvestmentTransactions> findByUserIdAndDate (Long userId, LocalDate startDate, LocalDate endDate);

}
