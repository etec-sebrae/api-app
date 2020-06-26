package br.gov.etec.app.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_curso")
public class Curso {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "nome",nullable = false, length = 55, unique = true)
	private String nome;
	@Column(name = "descricao", nullable = false, length = 255)
	private String descricao;
		
	
	public Curso() {
		
	}

	public Curso(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
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
	
}
