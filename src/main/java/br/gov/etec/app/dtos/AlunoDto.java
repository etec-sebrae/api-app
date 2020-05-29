package br.gov.etec.app.dtos;

import java.io.Serializable;
import java.util.Date;
public class AlunoDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6310666307879291066L;
	
	private String nome;
	private String rg;
	private String cpf;
	private String email;
	private Date data_nasc;
	private long id_curso;
	private String senha;
	
	
	public AlunoDto() {}
	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getId_curso() {
		return id_curso;
	}

	public void setId_curso(long id_curso) {
		this.id_curso = id_curso;
	}

	
	public Date getData_nasc() {
		return data_nasc;
	}



	public void setData_nasc(Date data_nasc) {
		this.data_nasc = data_nasc;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}



	@Override
	public String toString() {
		return "AlunoDto [nome=" + nome + ", rg=" + rg + ", cpf=" + cpf + ", email=" + email + ", id_curso=" + id_curso
				+ ", data_nasc=" + data_nasc + "]";
	}

		

}
