package br.gov.etec.app.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import br.gov.etec.app.dtos.AlunoDto;
import br.gov.etec.app.entity.AlunoCurso;
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
	private CursoService cursoService;
			
	@Autowired
	private UsuarioService usuarioService;	
	
	@Autowired
	private AlunoCursoService alunoCursoService;	
		
	public List<Pessoa> listar(Pageable pageable){				
		List<Pessoa> aluno = pessoaAlunoRepository.findByTipo(TipoEnum.ALUNO);
		pessoaAlunoRepository.flush();				
		return aluno;
	}
	
	public AlunoCurso cadastrar(AlunoDto alunoDto){
			
							
		Pessoa aluno = pessoaAlunoRepository.saveAndFlush(alunoDto.transformaAlunoDto());	
		Usuario usuario = usuarioService.criarUsuarioAluno(alunoDto.getEmail(),alunoDto.getSenha());
		
		aluno.setUsuario(usuario);
		pessoaAlunoRepository.saveAndFlush(aluno);
		
			
		Curso curso = cursoService.buscarPorId(alunoDto.getId_curso());
		AlunoCurso alunoCurso = alunoCursoService.criar(aluno,curso);					
		return alunoCurso;			
	}
		
	public Pessoa buscarPorId(long id){
		Pessoa aluno = pessoaAlunoRepository.findById(id);
		pessoaAlunoRepository.flush();
		return aluno;
	}
		
	
}
