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
@Table(name = "Log")
public class Logs {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long logId;
	
	@Column(nullable = false)
	private Boolean result;
	
	@Column(nullable = false)
	private int attempts;
	
	@Column(name = "dateHour",nullable = false)
	private LocalDateTime timestamp;
	
	@Column(nullable = false)
	private Long userId; 
	
	
	@ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;


	public Long getLogId() {
		return logId;
	}


	public void setLogId(Long logId) {
		this.logId = logId;
	}


	public Boolean getResult() {
		return result;
	}


	public void setResult(Boolean result) {
		this.result = result;
	}


	public int getAttempts() {
		return attempts;
	}


	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}


	public LocalDateTime getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
}