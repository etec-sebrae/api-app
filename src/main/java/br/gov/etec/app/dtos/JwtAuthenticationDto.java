package br.gov.etec.app.dtos;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("deprecation")
public class JwtAuthenticationDto {
	
	@NotEmpty(message = "Email não pode ser vazio")
	@Email(message = "Email invalido")
	private String email;
	@NotEmpty(message = "Senha não pode ser vazia")
	private String senha;
	
	public JwtAuthenticationDto() {
		
	}
		
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "wtAuthenticationRequestDto [email=" + email + ", senha=" + senha + "]";
	}
	
		
	
	

}
