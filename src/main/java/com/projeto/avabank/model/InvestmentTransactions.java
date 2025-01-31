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
@Table(name = "TransacaoInvest")
public class InvestmentTransactions {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "investmentTransactionId")
    private Long investmentTransactionId;

    @ManyToOne
    @JoinColumn(name = "investmentId", nullable = false, insertable = false, updatable = false)
    private InvestmentRegistration investmentRegistration;

    @ManyToOne
    @JoinColumn(name = "accountId", nullable = false, insertable = false, updatable = false)
    private Account account;

    @Column(nullable = false)
    private String transactionType;
    
    @Column(nullable = false)
    private BigDecimal transactionAmount;
    
    @Column(nullable = false)
    private LocalDateTime transactionDate;
    
    @Column(name = "summary", nullable = false)
    private String description;
    
    @Column(nullable = false)
    private LocalDateTime purchaseDate;
    
    @Column(nullable = false)
    private LocalDateTime redemptionDate;

    // Getters and Setters
    public Long getInvestmentTransactionId() {
        return investmentTransactionId;
    }

    public void setInvestmentTransactionId(Long investmentTransactionId) {
        this.investmentTransactionId = investmentTransactionId;
    }

    public InvestmentRegistration getInvestmentRegistration() {
        return investmentRegistration;
    }

    public void setInvestmentRegistration(InvestmentRegistration investmentRegistration) {
        this.investmentRegistration = investmentRegistration;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public LocalDateTime getRedemptionDate() {
        return redemptionDate;
    }

    public void setRedemptionDate(LocalDateTime redemptionDate) {
        this.redemptionDate = redemptionDate;
    }
}
