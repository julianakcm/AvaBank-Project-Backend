package com.projeto.avabank.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
 
@Entity
@Table(name = "CadInvestimento")
public class InvestmentRegistration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long investmentId;
	
	@Column(nullable = false)
	private String investmentType;
	
	@Column(nullable = false)
	private BigDecimal vinvestmentValue;
	
	@Column(nullable = false)
	private BigDecimal yield;
	
	@Column(name = "st", nullable = false)
	private String status;

	
	
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getInvestmentId() {
		return investmentId;
	}

	public void setInvestmentId(Long investmentId) {
		this.investmentId = investmentId;
	}

	public String getInvestmentType() {
		return investmentType;
	}

	public void setInvestmentType(String investmentType) {
		this.investmentType = investmentType;
	}

	public BigDecimal getVinvestmentValue() {
		return vinvestmentValue;
	}

	public void setVinvestmentValue(BigDecimal vinvestmentValue) {
		this.vinvestmentValue = vinvestmentValue;
	}

	public BigDecimal getYield() {
		return yield;
	}

	public void setYield(BigDecimal yield) {
		this.yield = yield;
	}

	
	
 
}