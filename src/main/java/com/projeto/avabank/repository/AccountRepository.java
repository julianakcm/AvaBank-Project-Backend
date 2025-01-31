package com.projeto.avabank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.avabank.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	
	
	
	Account findByCpf (String cpf);
	Account findByiD (String accountId);

	boolean findIfExistByAccountNumber(String randNumber);
	
	Account findByAccountAndAgency(String accountNumber, String agency);
	
}
