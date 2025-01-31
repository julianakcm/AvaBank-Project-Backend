package com.projeto.avabank.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.avabank.Dto.UserDTO;
import com.projeto.avabank.model.Account;
import com.projeto.avabank.model.Address;
import com.projeto.avabank.model.User;
import com.projeto.avabank.model.UserType;
import com.projeto.avabank.repository.AccountRepository;
import com.projeto.avabank.repository.AddressRepository;
import com.projeto.avabank.repository.UserRepository;
import com.projeto.avabank.repository.UserTypeRepository;

import jakarta.transaction.Transactional;

	@Service
	public class UserService {

	    @Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private AddressRepository addressRepository;

	    @Autowired
	    private AccountRepository accountRepository;

	    @Autowired
	    private UserTypeRepository userTypeRepository;

	    @Transactional
	    public UserDTO createUser(UserDTO userDTO) {
	        // Verifica se o CPF já está existe
	        if (userRepository.existByCpf(userDTO.getCpf())) {
	            throw new RuntimeException("Cpf já cadastrado");
	        }

	        // criando usuário
	        User user = new User();
	        user.setName(userDTO.getName());
	        user.setCpf(userDTO.getCpf());
	        user.setEmail(userDTO.getEmail());
	        user.setPhone(userDTO.getPhone());
	        user.setBirthDate(userDTO.getBirthDate());
	        user.setCreationDate(userDTO.getCreationDate());
	        user.setEnabled(true); 

	        // Criar UserType
	        UserType userType = userTypeRepository.findById(userDTO.getUserTypeId())
	                .orElseThrow(() -> new RuntimeException("Tipo de usuário não encontrado"));
	        user.setUserType(userType);

	      
	        userRepository.save(user);

	        // Criar e salvar o endereço
	        Address address = new Address();
	        address.setStreet(userDTO.getAddress().getStreet());
	        address.setNumber(userDTO.getAddress().getNumber());
	        address.setComplement(userDTO.getAddress().getComplement());
	        address.setPostalCode(userDTO.getAddress().getPostalCode());
	        address.setNeighborhood(userDTO.getAddress().getNeighborhood());
	        address.setCity(userDTO.getAddress().getCity());
	        address.setState(userDTO.getAddress().getState());
	        address.setUser(user);  
	        addressRepository.save(address);
	        
	     
	        user.setAddress(address);

	       
	        Account account = new Account();
	       account.setAccountNumber(createAccountNumber());  // Gera um número de conta automaticamente
	        account.setBalance(BigDecimal.ZERO);  
	        account.setUser(user);   
	        accountRepository.save(account);

	        // Associando a conta ao usuário
	        user.setAccount(account);

	        // Atualizando o usuário com o endereço e a conta associados
	        userRepository.save(user);

	        // Atualizando o DTO para retornar com o id gerado
	        userDTO.setUserId(user.getUserId());
	        userDTO.setAddress(userDTO.getAddress());
	        userDTO.setAccount(userDTO.getAccount());

	        return userDTO;
	    }
	
	    public String createAccountNumber() {
	        int min = 1000000;
	        int max = 9999999;

	        int randNumber = (int) (Math.random() * (max - min + 1) + min);

	        // Verificar se o número da conta já existe
	        while (accountRepository.findIfExistByAccountNumber(String.valueOf(randNumber))) {
	            randNumber = (int) (Math.random() * (max - min + 1) + min);
	        }

	        return String.valueOf(randNumber);
	    }
	        public Account createAccount(Account account) {
	            account.setAccountNumber(createAccountNumber()); 
	            return accountRepository.save(account);
	    }

	    
	  
	    
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
	
	
	public User updateUser(User user) {
		Long userId = user.getUserId();
		if (userId != null && userRepository.existsById(userId)) {
			return userRepository.save(user);
		}
		return null;
	}
}

	
	





















