package br.com.guarani.api.controller.form;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class LoginForm {
	
	private String email;
	private String senha;
	
	
	public void setEmail(String email) {
		this.email = email.toLowerCase();
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public String getSenha() {
		return senha;
	}
		
	public UsernamePasswordAuthenticationToken converter() {

	
		return new UsernamePasswordAuthenticationToken(email, senha);
		
	}
	
	
	

}
