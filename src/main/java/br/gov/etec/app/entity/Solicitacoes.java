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
@Table(name = "tb_solicitacoes")
public class Solicitacoes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "status", nullable = false, length = 1 )
	private int status;
	@Column(name = "dt_solicitacao", nullable = false)
	private Date data_solicitacao ;
	@ManyToOne
	@JoinColumn(name = "documento_id",referencedColumnName = "id",nullable = false)
	private Documento documento;
	@ManyToOne
	@JoinColumn(name = "aluno_id",referencedColumnName = "id",nullable = false)
	private Aluno aluno;
	
	public Solicitacoes() {
	
	}

	public Solicitacoes(int status, Date data_solicitacao, Documento documento, Aluno aluno) {
		super();
		this.status = status;
		this.data_solicitacao = data_solicitacao;
		this.documento = documento;
		this.aluno = aluno;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getData_solicitacao() {
		return data_solicitacao;
	}

	public void setData_solicitacao(Date data_solicitacao) {
		this.data_solicitacao = data_solicitacao;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	
	
}
