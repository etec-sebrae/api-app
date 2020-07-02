package br.gov.etec.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.gov.etec.app.enuns.TipoEnum;

@Entity
@Table(name = "tb_pessoa")
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private long id;
	@Column(name = "nome", nullable = false,length = 50)
	private String nome;
	@Column(name = "matricula", unique = true, nullable = false, length = 12)
	private long matricula;
	@Column(name = "rg", nullable = false, length = 12)
	private String rg;
	@Column(name = "cpf",nullable = false, length = 14,unique = true)
	private String cpf;	
	@Column(name = "data_nasc", nullable = false)
	private Date data_nasc;
	@Column(name = "email", nullable = false, unique = true, length = 55)
	private String email;
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo")
	private TipoEnum tipo; 
	@OneToOne
	private Usuario usuario;
	
	
	public Pessoa() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Pessoa(String nome, long matricula, String rg, String cpf, Date data_nasc, String email, TipoEnum tipo) {
		super();
		this.nome = nome;
		this.matricula = matricula;
		this.rg = rg;
		this.cpf = cpf;
		this.data_nasc = data_nasc;
		this.email = email;
		this.tipo = tipo;
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
	public long getMatricula() {
		return matricula;
	}
	public void setMatricula(long matricula) {
		this.matricula = matricula;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public TipoEnum getTipo() {
		return tipo;
	}
	public void setTipo(TipoEnum tipo) {
		this.tipo = tipo;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}
