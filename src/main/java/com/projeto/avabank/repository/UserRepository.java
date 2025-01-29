package com.projeto.avabank.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.avabank.model.User;

public interface UserRepository extends JpaRepository <User,Long>{
	
	User findByCpf (String cpf);
	User findByAccount (String accountNumber);
	boolean existByCpf(String cpf);
	User findByEmail(String email);
	

}
