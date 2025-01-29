package com.projeto.avabank.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
 
@Entity
@Table(name = "CadastroPix")
public class RegPixKey { //PixKey
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pixId;
	
	@Column(nullable = false)
	private String pixType;
	
	@Column(nullable = false)
	private String pix;
	
	@Column(nullable = false)
	private Long userId; 
	
	@ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

	public Long getPixId() {
		return pixId;
	}

	public void setPixId(Long pixId) {
		this.pixId = pixId;
	}

	public String getPixType() {
		return pixType;
	}

	public void setPixType(String pixType) {
		this.pixType = pixType;
	}

	public String getPix() {
		return pix;
	}

	public void setPix(String pix) {
		this.pix = pix;
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