package com.projeto.avabank.controller;

import com.projeto.avabank.Dto.ExtratoDTO;
import com.projeto.avabank.model.Transactions;
import com.projeto.avabank.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionsController {

    @Autowired
    private TransactionsService transactionsService;

    // Realizar saque
    @PostMapping("/saque")
    public ResponseEntity<Transactions> realizarSaque(@RequestParam Long sourceAccountId, @RequestParam BigDecimal amount) {
        try {
            Transactions transaction = transactionsService.realizarSaque(sourceAccountId, amount);
            return ResponseEntity.ok(transaction);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);  // Pode ser melhor especificar a exceção e retornar 400
        }
    }

    // Realizar depósito
    @PostMapping("/deposito")
    public ResponseEntity<Transactions> realizarDeposito(@RequestParam Long sourceAccountId, @RequestParam BigDecimal amount) {
        try {
            Transactions transaction = transactionsService.realizarDeposito(sourceAccountId, amount);
            return ResponseEntity.ok(transaction);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);  // Pode ser melhor especificar a exceção e retornar 400
        }
    }

    // Realizar transferência
    @PostMapping("/transferencia")
    public ResponseEntity<Transactions> realizarTransferencia(@RequestParam Long sourceAccountId, @RequestParam Long destinationAccountId, @RequestParam BigDecimal amount) {
        try {
            Transactions transaction = transactionsService.realizarTransferencia(sourceAccountId, destinationAccountId, amount);
            return ResponseEntity.ok(transaction);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);  // Pode ser melhor especificar a exceção e retornar 400
        }
    }

    // Realizar Pix
    @PostMapping("/pix")
    public ResponseEntity<Transactions> realizarPix(@RequestParam Long sourceAccountId, @RequestParam String pix, @RequestParam BigDecimal amount) {
        try {
            Transactions transaction = transactionsService.realizarPix(sourceAccountId, pix, amount);
            return ResponseEntity.ok(transaction);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);  // Pode ser melhor especificar a exceção e retornar 400
        }
    }

    // Consultar extrato (com intervalo de datas)
    @GetMapping("/extrato")
    public ResponseEntity<List<ExtratoDTO>> consultarExtrato(
            @RequestParam Long accountId,
            @RequestParam LocalDateTime startDate,
            @RequestParam LocalDateTime endDate) {
        List<ExtratoDTO> extrato = transactionsService.consultarExtrato(accountId, startDate, endDate);
        return ResponseEntity.ok(extrato);
    }
}
