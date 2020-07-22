package br.gov.etec.app.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_curso")
public class Curso {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "nome",nullable = false, length = 55, unique = true)
	private String nome;
	@Column(name = "descricao", nullable = false, length = 255)
	private String descricao;
	@Column(name = "stauts", length = 1)
	private int status;
	@Column(name = "codigo", length = 45)
	private String codigo;	
	@JsonIgnore
	@ManyToMany(mappedBy = "cursos", cascade = CascadeType.ALL)
	private List<Escola> escolas = new ArrayList<>();
	@ManyToMany(mappedBy = "cursos", cascade = CascadeType.ALL)
	private List<Pessoa> alunos = new ArrayList<>();
		
	
	public Curso() {
		
	}

	public Curso(String nome, String descricao, String codigo, int status) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.codigo = codigo;
		this.status = status;
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
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public List<Escola> getEscolas() {
		return escolas;
	}
	
	public void setEscolas(List<Escola> escolas) {
		this.escolas = escolas;
	}
	
}
