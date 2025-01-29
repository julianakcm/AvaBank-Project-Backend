package com.projeto.avabank.Dto;

import java.util.List;

import com.projeto.avabank.model.Address;
import com.projeto.avabank.model.Benefits;
import com.projeto.avabank.model.InvestmentRegistration;

import jakarta.transaction.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDetailsDTO {
	
	    private String name;
	    private String email;
	    private String phone;
	    private List<Address> addresses;
	    private List<Benefits> benefits;
	    private List<InvestmentRegistration> investments;
	    private List<Transaction> transactions; 
	    
	    
	    
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
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
		public List<Address> getAddresses() {
			return addresses;
		}
		public void setAddresses(List<Address> addresses) {
			this.addresses = addresses;
		}
		public List<Benefits> getBenefits() {
			return benefits;
		}
		public void setBenefits(List<Benefits> benefits) {
			this.benefits = benefits;
		}
		public List<InvestmentRegistration> getInvestments() {
			return investments;
		}
		public void setInvestments(List<InvestmentRegistration> investments) {
			this.investments = investments;
		}
		public List<Transaction> getTransactions() {
			return transactions;
		}
		public void setTransactions(List<Transaction> transactions) {
			this.transactions = transactions;
		}
	    
	    
	    

}
