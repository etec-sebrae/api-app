package br.gov.etec.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_documento")
public class Documento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "tipo", nullable = false, length = 50)
	private String tipo;
	@Column(name = "descricao", nullable = false, length = 100)
	private String descricao;
	
	
	public Documento() {
		
	}
	

	public Documento(String tipo, String descricao) {
		super();
		this.tipo = tipo;
		this.descricao = descricao;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	
}
