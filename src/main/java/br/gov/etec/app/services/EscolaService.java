package br.gov.etec.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import br.gov.etec.app.dtos.EscolaDto;
import br.gov.etec.app.entity.Curso;
import br.gov.etec.app.entity.Escola;
import br.gov.etec.app.repository.EscolaRepository;

@Service
public class EscolaService {
	
	@Autowired
	private EscolaRepository escolaRepository;
	
	@Autowired
	private CursoService cursoService;
		
	public Page<Escola> listar(Pageable pageable){
		Page<Escola> escola = escolaRepository.findAll(pageable);
		escolaRepository.flush();
		return escola;
	}
		
	public Escola cadastro(EscolaDto escolaDto) {
				
		Escola escola = escolaDto.transformaEscolaDto();		
				
		if (escolaDto.getCursos() != null) {
			List<Curso> listaCurso = new ArrayList<>();		
		
			for(int i = 0; i < escolaDto.getCursos().size();i++) {
				
				long id = escolaDto.getCursos().get(i).getId();			
				Curso curso = cursoService.buscarPorId(id);			
				listaCurso.add(curso);
				
			}
		
			escola.setCursos(listaCurso);
		}
						
		Escola escolaData = escolaRepository.save(escola);	
		escolaRepository.flush();
		
		return escolaData;
	}
	
}
