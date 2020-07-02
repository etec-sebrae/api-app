package br.gov.etec.app.dtos;

import java.util.Date;

import javax.validation.constraints.NotNull;
import br.gov.etec.app.entity.Curso;
import br.gov.etec.app.entity.Documento;
import br.gov.etec.app.entity.Pessoa;
import br.gov.etec.app.entity.SolicitacaoDocumento;

public class SolicitacaoDocumentoDto {
	
	@NotNull
	private long id_aluno;
	@NotNull
	private long id_documento;
	@NotNull
	private long id_curso;	
	private int status;
	
	public SolicitacaoDocumentoDto() {
		
	}
		
	public SolicitacaoDocumentoDto(long id_aluno, long id_documento, long id_curso) {
		super();
		this.id_aluno = id_aluno;
		this.id_documento = id_documento;
		this.id_curso = id_curso;
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
			
	public long getId_curso() {
		return id_curso;
	}

	public void setId_curso(long id_curso) {
		this.id_curso = id_curso;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public SolicitacaoDocumento transformaSolicitacoesDto(Documento documento, Pessoa aluno,Curso curso){
		return new SolicitacaoDocumento(1,new Date(),documento,aluno,curso);
	}

}
