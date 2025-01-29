package com.projeto.avabank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.avabank.model.Account;
import com.projeto.avabank.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	// Método para gerar o número da conta. o while é para testar se o número da
	// conta já existe e depois, caso exista (incluir o método findIfExistByAccountNumer no repository)
	//tentar até achar um número único.


	
	public String createAccountNumber() {
		int min = 1000000;
		int max = 9999999;

		int randNumber = (int) (Math.random()* (max - min + 1)+ min);
		while (accountRepository.findIfExistByAccountNumber(randNumber)) {
			randNumber = (int) (Math.random() * (max - min + 1) + min);
		}

		return String.valueOf(randNumber);

	}
	
	
	//----------------------------------------------------------------------------
	
	public Account createAccount(Account account) {
        account.setAccountNumber(createAccountNumber()); 
        return accountRepository.save(account);
    }

   
    public List<Account> getAllAccounts() {
        return accountRepository.findAll(); 
    }

   

     
    public Account findByCpf(String cpf) {
    	return accountRepository.findByCpf(cpf);
    	}
    
    
    public Account findById(Long accountId) {
        return accountRepository.findById(accountId).orElse(null); 
    }
      
 
    public Account updateAccount(Long id, Account updatedAccount) {
        Optional<Account> existingAccount = accountRepository.findById(id);
        if (existingAccount.isPresent()) {
            Account account = existingAccount.get();
            account.setBalance(updatedAccount.getBalance());
            account.setAccountId(updatedAccount.getAccountId());
       
            return accountRepository.save(account); 
        } else {
            return null; 
        }
    }

   
    public boolean deleteAccount(Long id) {
        Optional<Account> existingAccount = accountRepository.findById(id);
        if (existingAccount.isPresent()) {
            accountRepository.delete(existingAccount.get()); 
            return true; 
        }
        return false; 
    }
}
