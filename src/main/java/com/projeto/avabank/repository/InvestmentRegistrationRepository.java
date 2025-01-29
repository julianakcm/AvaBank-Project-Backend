package com.projeto.avabank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.avabank.model.InvestmentRegistration;

public interface InvestmentRegistrationRepository extends JpaRepository<InvestmentRegistration, Long>{

	List<InvestmentRegistration> findByUserId(Long userId);
}
