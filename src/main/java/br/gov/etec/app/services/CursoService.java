package br.gov.etec.app.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.gov.etec.app.dtos.CursoDto;
import br.gov.etec.app.entity.Curso;
import br.gov.etec.app.repository.CursoRepository;

@Service
public class CursoService {
	
	@Autowired
	private CursoRepository repository;
	
	public List<Curso> listarCursos(){		
		List<Curso> curso = repository.findAll();		
		repository.flush();		
		return curso;
	}
	
	public Curso cadastrarCurso(CursoDto cursoDto){
		
		Curso curso = repository.saveAndFlush(cursoDto.transformaCursoDto());	
		
		return curso;
	}
	
	public Curso buscarPorId(long id) {	
		Curso curso = repository.findById(id);
		repository.flush();
		return curso;
	}

}
