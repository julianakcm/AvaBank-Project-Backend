package com.projeto.avabank.model;

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
@Table(name = "Boletos")
public class Slips {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long slipId;
	
	@Column(nullable = false)
	private String barcode;
	
	@Column(nullable = false)
	private float amount;
	
	@Column(name = "st",nullable = false)
	private String status;
	
	@Column(nullable = false)
	private LocalDateTime dueDate;
	
	@Column(nullable = false)
	private LocalDateTime paymentDate;
	
	
	@Column(nullable = false)
	private String filePath;
	
	@Column(nullable = false)
	private String slipExtension;
	
	  @ManyToOne
	    @JoinColumn(name = "userId", nullable = false)
	    private User user;

	public long getSlipId() {
		return slipId;
	}

	public void setSlipId(long slipId) {
		slipId = slipId;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}

	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getSlipExtension() {
		return slipExtension;
	}

	public void setSlipExtension(String slipExtension) {
		this.slipExtension = slipExtension;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
}
