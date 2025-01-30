package com.projeto.avabank.Dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ExtratoDTO {
    
	    private Long AccountId;
	    private Long sourceAccountId;
	    private Long destinationAccountId; 
	    private BigDecimal amount; 
	    private String transactionType; 
	    private LocalDateTime timestamp;
	    
	    
	    
		public Long getAccountId() {
			return AccountId;
		}
		public void setAccountId(Long accountId) {
			AccountId = accountId;
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
		public BigDecimal getAmount() {
			return amount;
		}
		public void setAmount(BigDecimal amount) {
			this.amount = amount;
		}
		public String getTransactionType() {
			return transactionType;
		}
		public void setTransactionType(String transactionType) {
			this.transactionType = transactionType;
		}
		public LocalDateTime getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(LocalDateTime timestamp) {
			this.timestamp = timestamp;
		} 
	    
	    // Getters and setters

	   
	    }
	    
	    
