package br.gov.etec.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.domain.Page;

@Entity
@Table(name = "tb_relatorio")
public class Relatorio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_relatorio", nullable = false, length = 1 )
	private long idRelatorio;
	@Lob
	@Column(name = "imagem", nullable = false, length = 20971520 )
	private byte[] imagem;
	@Column(name = "status", nullable = false, length = 1 )
	private int status;
	@Column(name = "descricao", nullable = false )
	private String descricao;
	@ManyToOne
	private Pessoa aluno;
	
	public Relatorio(){}
	
	public Relatorio(byte[] imagem,int status, Pessoa aluno,String descricao) {
		super();
		this.imagem = imagem;
		this.status = status;
		this.aluno = aluno;
		this.descricao = descricao;
	}



	public long getIdRelatorio() {
		return idRelatorio;
	}

	public void setIdRelatorio(long idRelatorio) {
		this.idRelatorio = idRelatorio;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Pessoa getAluno() {
		return aluno;
	}

	public void setAluno(Pessoa aluno) {
		this.aluno = aluno;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static Page<Relatorio> findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
