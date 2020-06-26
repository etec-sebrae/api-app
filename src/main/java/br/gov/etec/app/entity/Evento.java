package br.gov.etec.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_evento")
public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "nome",nullable = false, length = 50)
	private String nome;
	@Column(name = "descricao",nullable = false, length = 100)
	private String descricao;
	@Column(name = "status",nullable = false, length = 1)
	private int status;
	@Column(name = "data_inicio",nullable = false)
	private Date dataInicio;
	@Column(name = "data_fim", nullable = false)
	private Date dataFim;
	
	public Evento() {
	}
		

	public Evento(String nome, String descricao, int status, Date dataInicio, Date dataFim) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.status = status;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
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

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	
	

}
