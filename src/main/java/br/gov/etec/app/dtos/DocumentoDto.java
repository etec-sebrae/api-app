package br.gov.etec.app.dtos;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.gov.etec.app.entity.Documento;

@SuppressWarnings("deprecation")
@JsonIgnoreProperties(ignoreUnknown = true)
public class DocumentoDto {
	
	@NotBlank
	private String tipo;
	@NotBlank
	private String descricao;
		
	
	public DocumentoDto() {
		
	}


	public DocumentoDto( String tipo,  String descricao) {
		super();
		this.tipo = tipo;
		this.descricao = descricao;
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
	
	public Documento tranformarDocumentoDto() {
		return new Documento(tipo,descricao);
	}

}
