package br.gov.etec.app.dtos;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.gov.etec.app.entity.Funcionario;
import br.gov.etec.app.entity.Login;

@SuppressWarnings("deprecation")
@JsonIgnoreProperties(ignoreUnknown = true)
public class FuncionarioDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6361202385230325251L;
	
	@NotBlank
	private String nome;
	@NotBlank
	private String email;
	@NotBlank
	private String senha;
	
	public FuncionarioDto() {
		// TODO Auto-generated constructor stub
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Funcionario tranformaOperadorDto(Login login) {
		return new Funcionario(nome,login);
	}


}
