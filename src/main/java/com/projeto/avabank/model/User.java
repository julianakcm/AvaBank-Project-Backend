package com.projeto.avabank.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usuarios")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@Column(name = "userName", nullable = false)
	private String name;
	
	@Column(nullable = false,unique = true)
	private String cpf;
	
	@Column(nullable = false)
	private LocalDate dbirthDate;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false, unique = true)
	private String phone;
	
	@Column(nullable = false)
	private LocalDateTime creationDate;
	
	@Column(nullable = false)
	private long userTypeId;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private boolean enabled;
	
	   @ManyToOne
	    @JoinColumn(name = "id_Tipo_Usuario", nullable = false)
	    private UserType userType;

	   
	    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
	    //private Set<Note> notes = new HashSet<>();
	    private Account account;


	    @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(
	        name = "users_user_types",
	        joinColumns = @JoinColumn(name = "user_id"),
	        inverseJoinColumns = @JoinColumn(name = "user_type_id")
	    )
	    private Set<UserType> userTypes = new HashSet<>();
	    
	    
		public Set<UserType> getUserTypes() {
			return userTypes;
		}


		public void setUserTypes(Set<UserType> userTypes) {
			this.userTypes = userTypes;
		}


		public boolean isEnabled() {
			return enabled;
		}


		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			password = password;
		}




		public Long getUserId() {
			return userId;
		}


		public void setUserId(Long userId) {
			this.userId = userId;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getCpf() {
			return cpf;
		}


		public void setCpf(String cpf) {
			this.cpf = cpf;
		}


		public LocalDate getDbirthDate() {
			return dbirthDate;
		}


		public void setDbirthDate(LocalDate dbirthDate) {
			this.dbirthDate = dbirthDate;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getPhone() {
			return phone;
		}


		public void setPhone(String phone) {
			this.phone = phone;
		}


		public LocalDateTime getCreationDate() {
			return creationDate;
		}


		public void setCreationDate(LocalDateTime creationDate) {
			this.creationDate = creationDate;
		}


		public long getUserTypeId() {
			return userTypeId;
		}


		public void setUserTypeId(long userTypeId) {
			this.userTypeId = userTypeId;
		}


		public UserType getUserType() {
			return userType;
		}


		public void setUserType(UserType userType) {
			this.userType = userType;
		}


		public Account getAccount() {
			return account;
		}


		public void setAccount(Account account) {
			this.account = account;
		}


	
	    
	    
}
