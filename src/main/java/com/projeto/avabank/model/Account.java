package com.projeto.avabank.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ContaBancaria")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountId;
	
	@Column(nullable = false)
	private String accountType;
	
	@Column(nullable = false)
	private String accountNumber;
	
	@Column(nullable = false)
	private int agency;
	
	@Column(nullable = false)
	private BigDecimal balance;
	
	@Column(nullable = true)
	private LocalDateTime creationDate;
	
	
	@Column(nullable = false, unique = true,length = 14)
	private String customerCpf;
	
	@Column(nullable = false)
	private int benefitId;
	
	@Column(nullable = false)
	private int userId;
	
	
	@ManyToMany
    @JoinTable(
        name = "Conta_Beneficio", 
        joinColumns = @JoinColumn(name = "accountId"), 
        inverseJoinColumns = @JoinColumn(name = "benefitId")  
    )
    private List<Benefits> beneficios;

    @OneToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User usuario;

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getAgency() {
		return agency;
	}

	public void setAgency(int agency) {
		this.agency = agency;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public String getCustomerCpf() {
		return customerCpf;
	}

	public void setCustomerCpf(String customerCpf) {
		this.customerCpf = customerCpf;
	}

	public int getBenefitId() {
		return benefitId;
	}

	public void setBenefitId(int benefitId) {
		this.benefitId = benefitId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<Benefits> getBeneficios() {
		return beneficios;
	}

	public void setBeneficios(List<Benefits> beneficios) {
		this.beneficios = beneficios;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}
    
    
    
    

    
}
