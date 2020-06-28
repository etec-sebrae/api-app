package br.gov.etec.app.dtos;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.gov.etec.app.entity.Documento;

@SuppressWarnings("deprecation")
@JsonIgnoreProperties(ignoreUnknown = true)
public class DocumentoDto {
	
	@NotBlank
	private String nome;
	@NotBlank
	private String descricao;
		
	
	public DocumentoDto() {
		
	}


	public DocumentoDto( String nome,  String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String tipo) {
		this.nome = tipo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Documento tranformarDocumentoDto() {
		return new Documento(nome,descricao);
	}

}
