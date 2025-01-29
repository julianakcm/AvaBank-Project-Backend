package com.projeto.avabank.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.projeto.avabank.model.Account;
import com.projeto.avabank.model.User;
import com.projeto.avabank.model.UserType;
import com.projeto.avabank.repository.AccountRepository;
import com.projeto.avabank.repository.UserRepository;
import com.projeto.avabank.repository.UserTypeRepository;

import jakarta.transaction.Transactional;

@Service
public class CustomService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserTypeRepository userTypeRepository;
	

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public User findUserByEmail(String email) {

		return userRepository.findByEmail(email);
	}

	public User findUserById(long id) {
		return userRepository.findById(id).orElse(null);
	}
	
	//---------------------------------------------------------------------------------------
	@Transactional
	public void saveUser(User user, String userTypeName) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setEnabled(true); 
	
	
		UserType userType = userTypeRepository.findByName(userTypeName);
		
		
		if (userType == null) {userType = new UserType();
		userType.setUserTypeName(userTypeName);
		userTypeRepository.save(userType);
	}
		
		Set<UserType> userTypes = new HashSet<>();
		userTypes.add(userType);
		user.setUserTypes(userTypes);
		
		userRepository.save(user);
		System.out.println("usuário salvo com sucesso!" + user.getEmail());
	}

	
	
	
	//---------------------------------------------------------------------------------------------
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	    User user = userRepository.findByEmail(email);
	    
	    if (user == null) {
	        throw new UsernameNotFoundException("Email do usuário não encontrado: " + email);
	    }
	    
	
	    return new org.springframework.security.core.userdetails.User(
	            user.getEmail(),
	            user.getPassword(),
	            getUserAuthority(user.getUserTypes()) 
	    );
	}
	
	
	//---------------------------------------------------------------------------------------------------------
	

//------------------------------------------------------------------------------------------------------
	
private List<GrantedAuthority> getUserAuthority(Set<UserType> userUserTypes) {
		
		
		Set<GrantedAuthority> userTypes = new HashSet<>();
		
		userUserTypes.forEach((role) -> {userTypes.add(new SimpleGrantedAuthority("ROLE_" + role.getUserTypeName()));}); 
		
		
		return new ArrayList<>(userTypes);
		
			
		
		
}

}









