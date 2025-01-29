package com.projeto.avabank.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.avabank.Dto.TransactionDTO; // Importando o DTO correto
import com.projeto.avabank.Exceptions.InsufficientBalanceException;
import com.projeto.avabank.model.Transactions;
import com.projeto.avabank.service.TransactionsService;

@RestController
@RequestMapping("/api/transactions")
public class TransactionsController {

    @Autowired
    private TransactionsService transactionService;

    // Endpoint to perform withdrawal
    @PostMapping("/saque")
    public ResponseEntity<TransactionDTO> realizarSaque(@RequestParam Long accountId, @RequestParam BigDecimal amount) {
        try {
            Transactions transaction = transactionService.realizarSaque(accountId, amount);
            return new ResponseEntity<>(new TransactionDTO(transaction), HttpStatus.OK);
        } catch (InsufficientBalanceException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new TransactionDTO(e.getMessage()));
        } catch (AccountNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new TransactionDTO(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new TransactionDTO("Erro interno: " + e.getMessage()));
        }
    }

    // Endpoint to perform deposit
    @PostMapping("/deposito")
    public ResponseEntity<TransactionDTO> realizarDeposito(@RequestParam Long accountId, @RequestParam BigDecimal amount) {
        try {
            Transactions transaction = transactionService.realizarDeposito(accountId, amount);
            return new ResponseEntity<>(new TransactionDTO(transaction), HttpStatus.OK);
        } catch (AccountNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new TransactionDTO(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new TransactionDTO("Erro interno: " + e.getMessage()));
        }
    }

    // Endpoint to perform transfer
    @PostMapping("/transferencia")
    public ResponseEntity<TransactionDTO> realizarTransferencia(
            @RequestParam Long sourceAccountId,
            @RequestParam Long destinationAccountId,
            @RequestParam BigDecimal amount) {

        try {
            Transactions transaction = transactionService.realizarTransferencia(sourceAccountId, destinationAccountId, amount);
            return new ResponseEntity<>(new TransactionDTO(transaction), HttpStatus.OK);
        } catch (InsufficientBalanceException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new TransactionDTO(e.getMessage()));
        } catch (AccountNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new TransactionDTO(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new TransactionDTO("Erro interno: " + e.getMessage()));
        }
    }

    // Endpoint to perform Pix transfer
    @PostMapping("/pix")
    public ResponseEntity<TransactionDTO> realizarPix(
            @RequestParam Long sourceAccountId,
            @RequestParam String pix,
            @RequestParam BigDecimal amount) {

        try {
            Transactions transaction = transactionService.realizarPix(sourceAccountId, pix, amount);
            return new ResponseEntity<>(new TransactionDTO(transaction), HttpStatus.OK);
        } catch (InsufficientBalanceException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new TransactionDTO(e.getMessage()));
        } catch (AccountNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new TransactionDTO(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new TransactionDTO("Erro interno: " + e.getMessage()));
        }
    }

    // Endpoint to generate statement (listing transactions within a period)
    @GetMapping("/extrato")
    public ResponseEntity<List<TransactionDTO>> consultarExtrato(
            @RequestParam Long accountId, 
            @RequestParam LocalDateTime startDate, 
            @RequestParam LocalDateTime endDate) {
        
        try {
            List<Transactions> transactions = transactionService.consultarExtrato(accountId, startDate, endDate);
            List<TransactionDTO> transactionDTOs = transactions.stream()
                    .map(TransactionDTO::new) // Convertendo cada transação para DTO
                    .collect(Collectors.toList());
            return new ResponseEntity<>(transactionDTOs, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
