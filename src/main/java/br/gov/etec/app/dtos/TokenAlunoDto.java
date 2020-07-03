package br.gov.etec.app.dtos;

import br.gov.etec.app.entity.AlunoCurso;

public class TokenAlunoDto {
	
	private String token;
	private AlunoCurso alunoCurso;
	
	public TokenAlunoDto(String token, AlunoCurso alunoCurso) {
		super();
		this.token = token;
		this.alunoCurso = alunoCurso;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public AlunoCurso getAlunoCurso() {
		return alunoCurso;
	}

	public void setAlunoCurso(AlunoCurso alunoCurso) {
		this.alunoCurso = alunoCurso;
	}
	
}
