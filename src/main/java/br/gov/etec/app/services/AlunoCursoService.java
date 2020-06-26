package br.gov.etec.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.etec.app.entity.AlunoCurso;
import br.gov.etec.app.entity.Curso;
import br.gov.etec.app.entity.Pessoa;
import br.gov.etec.app.repository.AlunoCursoRepository;

@Service
public class AlunoCursoService {
	
	@Autowired
	private AlunoCursoRepository alunoCursoRepository;

	public AlunoCurso salvar(Pessoa aluno, Curso curso) {
		
		AlunoCurso entity = new AlunoCurso(aluno,curso);
		
		return alunoCursoRepository.save(entity);
		
	}

}
