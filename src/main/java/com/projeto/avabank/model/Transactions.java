package com.projeto.avabank.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Transacoes")
public class Transactions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long transactionId;

	@Column(nullable = false)
	private long sourceAccountId;

	@Column(nullable = false)
	private long destinationAccountId;

	@Column(nullable = false)
	private BigDecimal amount;

	@Column(nullable = false)
	private String transactionType;

	@Column(name = "dateHour",nullable = false)
	private LocalDateTime timestamp;

	@Column
	private String description;

	@Column
	private float tfee;
	
	@Column
	private String pix;

	public String getPix() {
		return pix;
	}

	public void setPix(String pix) {
		this.pix = pix;
	}

	@ManyToOne
	@JoinColumn(name = "sourceAccountId", nullable = false)
	private Account sourceAccount;

	@ManyToOne
	@JoinColumn(name = "destinationAccountId;", nullable = false)
	private Account destinationAccount;

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public long getSourceAccountId() {
		return sourceAccountId;
	}

	public void setSourceAccountId(long sourceAccountId) {
		this.sourceAccountId = sourceAccountId;
	}

	public long getDestinationAccountId() {
		return destinationAccountId;
	}

	public void setDestinationAccountId(long destinationAccountId) {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getTfee() {
		return tfee;
	}

	public void setTfee(float tfee) {
		this.tfee = tfee;
	}

	public Account getSourceAccount() {
		return sourceAccount;
	}

	public void setSourceAccount(Account sourceAccount) {
		this.sourceAccount = sourceAccount;
	}

	public Account getDestinationAccount() {
		return destinationAccount;
	}

	public void setDestinationAccount(Account destinationAccount) {
		this.destinationAccount = destinationAccount;
	}

	
	
	
	

}
