package br.gov.etec.app.dtos;

import java.util.Date;

public class EventoDto {
	
	private String nome;
	private String descricao;
	private int status;
	private Date dataInico;
	private Date dataFim;
	
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
	public Date getDataInico() {
		return dataInico;
	}
	public void setDataInico(Date dataInico) {
		this.dataInico = dataInico;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
}
