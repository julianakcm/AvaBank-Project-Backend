package com.projeto.avabank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.avabank.model.Benefits;



public interface BenefitsRepository extends JpaRepository<Benefits, Long>{
	
	List<Benefits> findByUserId( Long userId);

}
