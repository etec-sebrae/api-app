package br.gov.etec.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_curso_escola")
public class CursoEscola {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	private Curso curso;
	@ManyToOne
	private Escola escola;
	
	public CursoEscola() {
		// TODO Auto-generated constructor stub
	}
	
		
	public CursoEscola(Curso curso, Escola escola) {
		super();
		this.curso = curso;
		this.escola = escola;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Escola getEscola() {
		return escola;
	}
	public void setEscola(Escola escola) {
		this.escola = escola;
	} 
	
	
}
