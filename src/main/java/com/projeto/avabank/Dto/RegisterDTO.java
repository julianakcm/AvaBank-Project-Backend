package com.projeto.avabank.Dto;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
 
public class RegisterDTO {
	// DEFINIR OS ATRIBUTOS DO DTO 
	@NotBlank(message = "O email é o obrigatorio") // não pode estar "vazio"
	@Email(message = "O email deve ser valido")
	private String email;
	@NotBlank(message = "A senha é obrigatória")
	@Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres")
	private String password;
	@NotBlank(message = "O nome completo é obrigatório")
	private String name ;
 
	public String getEmail() {  
		return email;
	}
 
	public void setEmail(String email) {
		this.email = email;
	}
 
	public String getPassword() {
		return password;
	}
 
	public void setPassword(String password) {
		this.password = password;
	}
 
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}

}