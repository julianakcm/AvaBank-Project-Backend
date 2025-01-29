package com.projeto.avabank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.avabank.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{
	
	Address findByUserName(String userName);

}
