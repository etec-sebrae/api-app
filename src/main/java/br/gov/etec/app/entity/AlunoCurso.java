package br.gov.etec.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_aluno_curso")
public class AlunoCurso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	private Pessoa pessoa;
	@ManyToOne
	private Curso curso;
	
	public AlunoCurso() {
		// TODO Auto-generated constructor stub
	}
	

	public AlunoCurso(Pessoa pessoa, Curso curso) {
		super();
		this.pessoa = pessoa;
		this.curso = curso;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	

}
