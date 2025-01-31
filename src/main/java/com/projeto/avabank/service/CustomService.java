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
        // Criptografando a senha
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setEnabled(true);

        // Obtendo o tipo de usuário
        UserType userType = userTypeRepository.findByName(userTypeName);

        // Se o tipo de usuário não existir, criamos um novo
        if (userType == null) {
            userType = new UserType();
            userType.setUserTypeName(userTypeName);
            userTypeRepository.save(userType);
        }

        // Aqui, estamos associando apenas um tipo de usuário ao usuário
        user.setUserType(userType);
        
        // Salvando o usuário no banco de dados
        userRepository.save(user);
        System.out.println("Usuário salvo com sucesso! " + user.getEmail());
    }

    //---------------------------------------------------------------------------------------------
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        
        if (user == null) {
            throw new UsernameNotFoundException("Email do usuário não encontrado: " + email);
        }

        // Usando o tipo de usuário (agora, como apenas um tipo) para a autoridade
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                getUserAuthority(user.getUserType()) // Alterado para um único tipo
        );
    }

    //---------------------------------------------------------------------------------------------------------
    
    private List<GrantedAuthority> getUserAuthority(UserType userType) {
        // Aqui, agora, userType é único, então não precisamos de Set
        Set<GrantedAuthority> userTypes = new HashSet<>();
        
        // Adicionando a autoridade
        if (userType != null) {
            userTypes.add(new SimpleGrantedAuthority("ROLE_" + userType.getUserTypeName()));
        }

        return new ArrayList<>(userTypes);
    }
}
