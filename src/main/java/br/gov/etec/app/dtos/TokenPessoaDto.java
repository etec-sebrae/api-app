package br.gov.etec.app.dtos;

import br.gov.etec.app.entity.Pessoa;

public class TokenPessoaDto {
	
	private String token;
	private Pessoa pessoa;
	
	public TokenPessoaDto() {
		
	}
	
	public TokenPessoaDto(String token) {
		super();
		this.token = token;
	}

	public TokenPessoaDto(String token, Pessoa pessoa) {
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
