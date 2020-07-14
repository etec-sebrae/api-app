package br.gov.etec.app.dtos;

import br.gov.etec.app.entity.Pessoa;

public class TokenDto {
	
	private String token;
	private Pessoa pessoa;
	
	public TokenDto() {
		
	}
	
	public TokenDto(String token) {
		super();
		this.token = token;
	}

	public TokenDto(String token, Pessoa pessoa) {
		super();
		this.token = token;
		this.pessoa = pessoa;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public Pessoa getPessoa() {
		return pessoa;
	}


	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	

}
