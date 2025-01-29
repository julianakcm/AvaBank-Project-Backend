package com.projeto.avabank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.avabank.model.Logs;

public interface LogsRepository extends JpaRepository<Logs, Long>{
	
	  List<Logs> findByUserId(Long UserId); // todos os logs de um usuário
	  
	  Logs countByUserIdAndAttempts (Long UserId, Boolean result);
	  

}
