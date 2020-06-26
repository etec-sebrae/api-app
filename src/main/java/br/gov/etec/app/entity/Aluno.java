package br.gov.etec.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="tb_aluno")
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private long id;
	@Column(name = "nome", nullable = false,length = 50)
	private String nome;
	@Column(name = "rg", nullable = false, length = 12)
	private String rg;
	@Column(name = "cpf",nullable = false, length = 14,unique = true)
	private String cpf;	
	@Column(name = "matricula", unique = true, nullable = false, length = 12)
	private long matricula;
	@Column(name = "dt_nascimento", nullable = false)
	private Date data_nasc;
	@ManyToOne
	@JoinColumn(name = "curso_id",referencedColumnName = "id",nullable = false)
	private Curso curso;
	@ManyToOne
	@JoinColumn(name = "login_id",referencedColumnName = "id",nullable = false)
	private Login login;
		
	
	public Aluno() {
		// TODO Auto-generated constructor stub
	}
		
	public Aluno(String nome, String rg, String cpf,long matricula, Date data_nasc, Curso curso, Login login) {
		super();
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.matricula = matricula;
		this.data_nasc = data_nasc;
		this.curso = curso;
		this.login = login;
		
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
		
	public Date getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(Date data_nasc) {
		this.data_nasc = data_nasc;
	}
	
	public Curso getCurso() {
		return curso;
	}


	public void setCurso(Curso curso) {
		this.curso = curso;
	}


	public Login getLogin() {
		return login;
	}


	public void setLogin(Login login) {
		this.login = login;
	}

	public long getMatricula() {
		return matricula;
	}

	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}
		
}
