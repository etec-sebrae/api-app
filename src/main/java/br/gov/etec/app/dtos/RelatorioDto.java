package br.gov.etec.app.dtos;

import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

import br.gov.etec.app.entity.Pessoa;
import br.gov.etec.app.entity.Relatorio;

public class RelatorioDto {
	
	@Lob
	private byte[] imagem;
	@NotNull
	private String descricao;
	private long id_aluno;
	private int status;
	
	public RelatorioDto() {
		
	}
		
	public RelatorioDto(long id_aluno) {
		super();
		this.id_aluno = id_aluno;

	}


	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}
	

	public long getId_aluno() {
		return id_aluno;
	}

	public void setId_aluno(long id_aluno) {
		this.id_aluno = id_aluno;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Relatorio transformaRelatorioDto(Pessoa aluno){
		return new Relatorio(imagem,status,aluno,descricao);
	}


	
}
