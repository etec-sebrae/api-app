package br.gov.etec.app.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import br.gov.etec.app.dtos.AlunoDto;
import br.gov.etec.app.entity.Curso;
import br.gov.etec.app.entity.Pessoa;
import br.gov.etec.app.entity.Usuario;
import br.gov.etec.app.enuns.TipoEnum;
import br.gov.etec.app.repository.PessoaRepository;

@Service
public class AlunoService {
	@Autowired
	private PessoaRepository pessoaAlunoRepository;
						
	@Autowired
	private UsuarioService usuarioService;	
	
	@Autowired
	private CursoService cursoService;
		
		
	public List<Pessoa> listar(Pageable pageable){				
		List<Pessoa> aluno = pessoaAlunoRepository.findByTipo(TipoEnum.ALUNO);
		pessoaAlunoRepository.flush();				
		return aluno;
	}
	
	public Pessoa cadastrar(AlunoDto alunoDto){
									
		Pessoa aluno = alunoDto.transformaAlunoDto();	
		
		List<Curso> listaCurso = new ArrayList<>();		
		for(int i = 0; i < alunoDto.getCursos().size();i++) {			
			long id = alunoDto.getCursos().get(i).getId();			
			Curso curso = cursoService.buscarPorId(id);			
			listaCurso.add(curso);			
		}		
		aluno.setCursos(listaCurso);
		
		Pessoa alunoData = pessoaAlunoRepository.save(aluno);
		
		Usuario usuario = usuarioService.criarUsuarioAluno(alunoDto.getEmail(),alunoDto.getSenha());		
		alunoData.setUsuario(usuario);
			
		pessoaAlunoRepository.save(aluno);	
		
		return aluno;			
	}
		
	public Pessoa buscarPorId(long id){
		Pessoa aluno = pessoaAlunoRepository.findById(id);
		pessoaAlunoRepository.flush();
		return aluno;
	}
		
	
}
