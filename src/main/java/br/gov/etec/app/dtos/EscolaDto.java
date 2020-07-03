package br.gov.etec.app.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import br.gov.etec.app.entity.Escola;

public class EscolaDto {
	
	@NotBlank
	private String nome;
	@NotBlank
	@Email
	private String email;
	@NotBlank
	private String codigo;
	@NotNull
	private int status;
		
	
	public EscolaDto(String nome, String email, String codigo, int status) {
		super();
		this.nome = nome;
		this.email = email;
		this.codigo = codigo;
		this.status = status;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
		
	public Escola transformaEscolaDto() {
		return new Escola(nome, email, codigo, status);
	}
	

}
