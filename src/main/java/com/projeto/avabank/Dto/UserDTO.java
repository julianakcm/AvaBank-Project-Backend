package com.projeto.avabank.Dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserDTO {

	private Long userId;
	private String name;
	private String cpf;
	private LocalDate dbirthDate;
	private String email;
	private String phone;
	private LocalDateTime creationDate;
	private long userTypeId;
	private String password;
	private boolean enabled;
	
	
	private AccountDTO account;
	  
	private AddressDTO address;
	
	private UserTypeDTO userType;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public AccountDTO getAccount() {
		return account;
	}

	public void setAccount(AccountDTO account) {
		this.account = account;
	}

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}

	public UserTypeDTO getUserType() {
		return userType;
	}

	public void setUserType(UserTypeDTO userType) {
		this.userType = userType;
	}
	
	
	
	
	
	
}
