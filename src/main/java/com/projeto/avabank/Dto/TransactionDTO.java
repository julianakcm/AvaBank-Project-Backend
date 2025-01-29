package com.projeto.avabank.Dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.projeto.avabank.model.Transactions;

public class TransactionDTO {

    private Long transactionId;
    private Long sourceAccountId;
    private Long destinationAccountId;
    private String transactionType;
    private BigDecimal amount;
    private LocalDateTime timestamp;
    private String errorMessage; // Caso haja erro, essa mensagem será retornada

    // Construtor para transação bem-sucedida
    public TransactionDTO(Transactions transaction) {
        this.transactionId = transaction.getTransactionId();
        this.sourceAccountId = transaction.getSourceAccountId();
        this.destinationAccountId = transaction.getDestinationAccountId();
        this.transactionType = transaction.getTransactionType();
        this.amount = transaction.getAmount();
        this.timestamp = transaction.getTimestamp();
    }

    // Construtor para erro (quando algo falha)
    public TransactionDTO(String errorMessage) {
        this.errorMessage = errorMessage;
    }

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		transactionId = transactionId;
	}

	public Long getSourceAccountId() {
		return sourceAccountId;
	}

	public void setSourceAccountId(Long sourceAccountId) {
		this.sourceAccountId = sourceAccountId;
	}

	public Long getDestinationAccountId() {
		return destinationAccountId;
	}

	public void setDestinationAccountId(Long destinationAccountId) {
		this.destinationAccountId = destinationAccountId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

    // Getters e Setters
    
}
