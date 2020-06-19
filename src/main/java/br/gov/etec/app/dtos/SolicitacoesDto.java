package br.gov.etec.app.dtos;

import java.util.Date;

import javax.validation.constraints.NotNull;


import br.gov.etec.app.entity.Aluno;
import br.gov.etec.app.entity.Documento;
import br.gov.etec.app.entity.Solicitacoes;


public class SolicitacoesDto {
	
	@NotNull
	private long id_aluno;
	@NotNull
	private long id_documento;
	
	public SolicitacoesDto() {
		
	}
	
	
	public SolicitacoesDto(long id_aluno, long id_documento) {
		super();
		this.id_aluno = id_aluno;
		this.id_documento = id_documento;
	}


	public long getId_aluno() {
		return id_aluno;
	}
	public void setId_aluno(long id_aluno) {
		this.id_aluno = id_aluno;
	}
	public long getId_documento() {
		return id_documento;
	}
	public void setId_documento(long id_documento) {
		this.id_documento = id_documento;
	}
	
	public Solicitacoes transformaSolicitacoesDto(Documento documento, Aluno aluno){
		return new Solicitacoes(1,new Date(),documento,aluno);
	}

}
