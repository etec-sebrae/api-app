package br.gov.etec.app.dtos;

import java.io.Serializable;
import org.hibernate.validator.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import br.gov.etec.app.entity.Curso;

@SuppressWarnings("deprecation")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CursoDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4126300812484790031L;

	@NotBlank
	private String nome;
	@NotBlank
	private String descricao;
	@NotBlank
	private String codigo;
		
	public CursoDto() {}
	
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
