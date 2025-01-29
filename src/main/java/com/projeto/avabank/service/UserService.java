package com.projeto.avabank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.avabank.model.Address;
import com.projeto.avabank.model.User;
import com.projeto.avabank.model.UserType;
import com.projeto.avabank.repository.AccountRepository;
import com.projeto.avabank.repository.AddressRepository;
import com.projeto.avabank.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private AccountRepository accountRepository;
/*
	@Transactional
	public User createUser(User user, Address address, UserType userType) {
		if (userRepository.existByCpf(user.getCpf())) {
			throw new RuntimeException("Cpf já cadastrado");
		}
		
		User savedUser = userRepository.save(user);

		return savedUser;
	}
	*/
	
	
	//----------------------------------
	
	
	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findByCpf(String cpf) {
		return userRepository.findByCpf(cpf);
	}
	
	
	public void deleteById(Long id) {
		if (userRepository.existsById(id)) {
			userRepository.deleteById(id);
		}
	}

	public void deleteAll() {
		userRepository.deleteAllInBatch(); // verificar
	}
	
	
	public User update(User user) {
		Long userId = user.getUserId();
		if (userId != null && userRepository.existsById(userId)) {
			return userRepository.save(user);
		}
		return null;
	}
}

	
	





















