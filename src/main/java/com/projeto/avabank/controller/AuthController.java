package com.projeto.avabank.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projeto.avabank.Dto.LoginDTO;
import com.projeto.avabank.Dto.RegisterDTO;
import com.projeto.avabank.model.User;
import com.projeto.avabank.service.CustomService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RequestMapping("/api/user")
public class AuthController {
	
	@Autowired
	private CustomService userService;
	
	@Autowired 
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginDTO loginDto){
		try {
		
			Authentication authentication = authenticationManager.authenticate(
						new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword())
					);
			
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
	
			Map<String, String> response = new HashMap<>();
			response.put("message", "Login feito com sucesso");
			return ResponseEntity.ok(response);
			
		}catch(Exception e){
			
			Map<String, String> errorResponse = new HashMap<>();
			errorResponse.put("error", "Login não efetuado" + e.getMessage());
			
			
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
		
		}
		}
		public ResponseEntity<?> createNewUser(
				@Valid @RequestBody RegisterDTO registerDto,
				BindingResult bindingResult,
				@RequestParam String userTypeName
				
			){
		
	
		User userExists = userService.findUserByEmail(registerDto.getEmail());
		
	
		
		if(userExists != null) {
			bindingResult.rejectValue("email", "error.user", "O email já é cadastrado em um usuário");
			}
		
		
		
		if(bindingResult.hasErrors()) {
			
			Map<String, String> errors = new HashMap<>();
			for(FieldError error: bindingResult.getFieldErrors()) {
				errors.put(error.getField(), error.getDefaultMessage());
			}
			
			return ResponseEntity.badRequest().body(errors);
		}
		
		
		
		User user = new User();
		user.setEmail(registerDto.getEmail());
		user.setPassword(registerDto.getPassword());
		user.setName(registerDto.getName());
		
	
		userService.saveUser(user,userTypeName);
		
		
	
		
		Map<String, String> response  = new HashMap<>();
		response.put("message", "Usuario cadastrado com sucesso!");
		
		return ResponseEntity.ok(response);
	}
	
	
		@PostMapping("/logout")
		public ResponseEntity<Void> logout(
			HttpServletRequest request, HttpServletResponse response){
			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			
		
			if(authentication != null) {
				
				new SecurityContextLogoutHandler().logout(request, response, authentication);
				System.out.println("Logout efetuada com sucesso para o usuário: " + authentication.getName());
			}else {
				
				System.out.println("Tentativa de logout sem usuário autenticado!");
			}
			
		
			return ResponseEntity.noContent().build();
		}
		
}