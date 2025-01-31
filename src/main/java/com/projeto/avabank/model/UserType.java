package com.projeto.avabank.model;
import java.util.HashSet;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TipoUsuario")
public class UserType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userTypeId;

    @Column(nullable = false)
    private String userTypeName;


  
 


	public Long getUserTypeId() {
		return userTypeId;
	}



	public void setUserTypeId(Long userTypeId) {
		this.userTypeId = userTypeId;
	}



	public String getUserTypeName() {
		return userTypeName;
	}



	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}



}