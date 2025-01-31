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
@Table(name = "RegPixKey")
public class RegPixKey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pixId;

    @Column(nullable = false)
    private Long userId;  // Coluna user_id

    // Outros campos...

    @ManyToOne
    @JoinColumn(name = "userId", insertable = false, updatable = false, nullable = false)  // Evitar duplicação de mapeamento
    private User user;

    // Getters e Setters
   
    
    public Long getUserId() {
        return userId;
    }

    public Long getPixId() {
		return pixId;
	}

	public void setPixId(Long pixId) {
		this.pixId = pixId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setUserId(long userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
