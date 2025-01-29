package com.projeto.avabank.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.avabank.Dto.ExtratoDTO;
import com.projeto.avabank.Exceptions.InsufficientBalanceException;
import com.projeto.avabank.model.Account;
import com.projeto.avabank.model.Transactions;
import com.projeto.avabank.repository.AccountRepository;
import com.projeto.avabank.repository.TransactionsRepository;

import jakarta.transaction.Transactional;



	@Service
	public class TransactionsService {
	    @Autowired
	    private AccountRepository accountRepository;

	    @Autowired
	    private TransactionsRepository transactionRepository;
	    
	    
	    @Transactional
	    public Transactions realizarSaque(Long sourceAccountId, BigDecimal amount) throws AccountNotFoundException, InsufficientBalanceException {
	        
	        Account sourceAccount = accountRepository.findById(sourceAccountId)
	                .orElseThrow(() -> new AccountNotFoundException("Account not found"));
	     
	       
	        if (sourceAccount.getBalance().compareTo(amount) < 0) {
	            throw new InsufficientBalanceException("Insufficient balance");
	        }
	     
	      
	        Transactions transaction = new Transactions();
	        transaction.setSourceAccountId(sourceAccountId);
	        transaction.setAmount(amount);
	        transaction.setTransactionType("SAQUE");
	        transaction.setTimestamp(LocalDateTime.now());
	     
	    
	        sourceAccount.setBalance(sourceAccount.getBalance().subtract(amount));
	     
	  
	        accountRepository.save(sourceAccount);
	        transactionRepository.save(transaction);
	     
	        return transaction;
	    }
	    
	    

	    public Transactions realizarDeposito(Long sourceAccountId, BigDecimal amount) throws AccountNotFoundException {

	    	Account sourceAccount = accountRepository.findById(sourceAccountId).orElseThrow(() -> new AccountNotFoundException("Account not found"));
	    	 
	        Transactions transaction = new Transactions();
	        transaction.setSourceAccountId(sourceAccountId);
	        transaction.setAmount(amount);
	        transaction.setTransactionType("DEPOSITO");
	        transaction.setTimestamp(LocalDateTime.now());

	       
	        sourceAccount.setBalance(sourceAccount.getBalance().add(amount));
	        accountRepository.save(sourceAccount);


	        
	        transactionRepository.save(transaction);

	        return transaction;
	    }
	    

	    public Transactions realizarTransferencia(Long sourceAccountId, Long destinationAccountId, BigDecimal amount) throws AccountNotFoundException, InsufficientBalanceException {
	    	Account sourceAccount = accountRepository.findById(sourceAccountId).orElseThrow(() -> new AccountNotFoundException("Source account not found"));
	        Account destinationAccount = accountRepository.findById(destinationAccountId).orElseThrow(() -> new AccountNotFoundException("Destination account not found"));

	        if (sourceAccount.getBalance().compareTo(amount) < 0) {
	            throw new InsufficientBalanceException("Insufficient balance to perform the transfer.");
	        }

	        Transactions transaction = new Transactions();
	        transaction.setSourceAccountId(sourceAccountId);
	        transaction.setDestinationAccountId(destinationAccountId);
	        transaction.setAmount(amount);
	        transaction.setTransactionType("TRANSFER");
	        transaction.setTimestamp(LocalDateTime.now());
	     


	   
	        sourceAccount.setBalance(sourceAccount.getBalance().subtract(amount));
	        destinationAccount.setBalance(destinationAccount.getBalance().add(amount));
	        accountRepository.save(sourceAccount);
	        accountRepository.save(destinationAccount);


	    
	        transactionRepository.save(transaction);


	        return transaction;
	    }

	    public Transactions realizarPix(Long sourceAccountId, String pix, BigDecimal amount) throws AccountNotFoundException, InsufficientBalanceException {

	    	Account sourceAccount = accountRepository.findById(sourceAccountId).orElseThrow(() -> new AccountNotFoundException("Account not found"));

	    			if (sourceAccount.getBalance().compareTo(amount) < 0) {
	    		        throw new InsufficientBalanceException("Insufficient balance to perform the Pix.");
	    		    }


	    	Transactions transaction = new Transactions();
	        transaction.setSourceAccountId(sourceAccountId);
	        transaction.setPix(pix);
	        transaction.setAmount(amount);
	        transaction.setTransactionType("PIX");
	        transaction.setTimestamp(LocalDateTime.now());


	    
	        sourceAccount.setBalance(sourceAccount.getBalance().subtract(amount));
	        accountRepository.save(sourceAccount);

	     
	        transactionRepository.save(transaction);

	        return transaction;
	    }

	    
	    public List<ExtratoDTO> consultarExtrato(Long accountId, LocalDateTime startDate, LocalDateTime endDate) {

	    
	    	List<Transactions> transactions = transactionRepository.findBySourceAccountIdAndDateTimeBetween(accountId, startDate, endDate);

	     
	    	return transactions.stream().map(transaction -> {
	            ExtratoDTO dto = new ExtratoDTO();
	          //  dto.setId(transaction.getId());
	            dto.setSourceAccountId(transaction.getSourceAccountId());
	            dto.setDestinationAccountId(transaction.getDestinationAccountId());
	            dto.setAmount(transaction.getAmount());
	            dto.setTransactionType(transaction.getTransactionType()); 
	            dto.setTimestamp(transaction.getTimestamp());
	            return dto;
	        }).collect(Collectors.toList());
	    }

	  
	}

	
