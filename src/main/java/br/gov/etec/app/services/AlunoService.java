package br.gov.etec.app.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
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
		
	public List<Pessoa> listar(){				
		List<Pessoa> aluno = pessoaAlunoRepository.findByTipo(TipoEnum.ALUNO);
		pessoaAlunoRepository.flush();				
		return aluno;
	}
	
	public AlunoCurso cadastrar(AlunoDto alunoDto,BindingResult result){
				
		if(result.hasErrors()) {
			return null;
		}
		
		Usuario usuario = usuarioService.criarUsuarioAluno(alunoDto.getEmail(),alunoDto.getSenha());		
		Pessoa aluno = pessoaAlunoRepository.saveAndFlush(alunoDto.transformaAlunoDto(usuario));
			
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
