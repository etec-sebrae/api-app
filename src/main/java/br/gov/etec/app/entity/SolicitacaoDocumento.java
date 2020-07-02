package br.gov.etec.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_solicitacao_documento")
public class SolicitacaoDocumento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "status", nullable = false, length = 1 )
	private int status;
	@Column(name = "data_abertura", nullable = false)
	private Date data_abertura ;
	@Column(name = "data_conclusao")
	private Date data_conclusao ;
	@ManyToOne
	private Documento documento;
	@ManyToOne
	private Pessoa aluno;
	@ManyToOne
	private Curso curso;
		
	public SolicitacaoDocumento() {
	
	}
	
	public SolicitacaoDocumento(int status, Date data_abertura, Documento documento, Pessoa aluno,
			Curso curso) {
		super();
		this.status = status;
		this.data_abertura = data_abertura;
		this.documento = documento;
		this.aluno = aluno;
		this.curso = curso;
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

	public Date getData_abertura() {
		return data_abertura;
	}

	public void setData_abertura(Date data_abertura) {
		this.data_abertura = data_abertura;
	}

	public Date getData_conclusao() {
		return data_conclusao;
	}

	public void setData_conclusao(Date data_conclusao) {
		this.data_conclusao = data_conclusao;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public Pessoa getAluno() {
		return aluno;
	}

	public void setAluno(Pessoa aluno) {
		this.aluno = aluno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	
}
