package com.projeto.avabank.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
 
 
@Entity
@Table(name = "Beneficios")
public class Benefits {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long benefitId;
	
	@Column(nullable = false)
	private String benefitType;
	
	@Column(name = "summary",nullable = false)
	private String description;
	
	@Column(name = "valueBenefit",nullable = false)
	private double value;

	public long getBenefitId() {
		return benefitId;
	}

	public void setBenefitId(long benefitId) {
		this.benefitId = benefitId;
	}

	public String getBenefitType() {
		return benefitType;
	}

	public void setBenefitType(String benefitType) {
		this.benefitType = benefitType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	

}