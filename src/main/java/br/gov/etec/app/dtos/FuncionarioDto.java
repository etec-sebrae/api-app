package br.gov.etec.app.dtos;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import br.gov.etec.app.entity.Pessoa;
import br.gov.etec.app.enuns.TipoEnum;

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
	private String rg;
	@NotBlank
	private String cpf;
	@NotNull
	private long matricula;
	@NotBlank
	@Email
	private String email;
	@NotNull
	private Date data_nasc;
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

	public long getMatricula() {
		return matricula;
	}

	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Pessoa tranformaFuncionarioDto() {
		return new Pessoa(nome,matricula,rg,cpf,data_nasc,email,TipoEnum.FUNCIONARIO);
	}


}
