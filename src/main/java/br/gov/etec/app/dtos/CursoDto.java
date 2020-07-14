package br.gov.etec.app.dtos;

import org.hibernate.validator.constraints.NotBlank;
import br.gov.etec.app.entity.Curso;

@SuppressWarnings("deprecation")
public class CursoDto {
	

	@NotBlank
	private String nome;
	@NotBlank
	private String descricao;
	@NotBlank
	private String codigo;
		
	public CursoDto(){}
	
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
		
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Curso transformaCursoDto() {
		return new Curso(nome,descricao,codigo);
	}

}
