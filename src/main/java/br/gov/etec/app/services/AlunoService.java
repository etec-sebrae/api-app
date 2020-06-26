package br.gov.etec.app.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import br.gov.etec.app.dtos.AlunoDto;
import br.gov.etec.app.entity.AlunoCurso;
import br.gov.etec.app.entity.Curso;
import br.gov.etec.app.entity.Pessoa;
import br.gov.etec.app.entity.Usuario;
import br.gov.etec.app.enuns.PerfilEnum;
import br.gov.etec.app.repository.CursoReposity;
import br.gov.etec.app.repository.PessoaRepository;
import br.gov.etec.app.response.Response;
import br.gov.etec.app.security.senhaUtils;

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
	
	
	
	
	public ResponseEntity<Response<List<Pessoa>>> listar(){
		Response<List<Pessoa>> response = new Response<>();
		
		List<Pessoa> aluno = pessoaAlunoRepository.findAll();
		pessoaAlunoRepository.flush();
		
		response.setData(aluno);
		
		return ResponseEntity.ok(response);
	}

	
	public ResponseEntity<Response<AlunoCurso>> cadastrar(AlunoDto alunoDto,BindingResult result){
		Response<AlunoCurso> response = new Response<>();
		
		if(result.hasErrors()) {
			return null;
		}
		
		Usuario usuario = usuarioService.criarUsuarioAluno(alunoDto.getEmail(),alunoDto.getSenha());		
		Pessoa aluno = pessoaAlunoRepository.save(alunoDto.transformaAlunoDto(usuario));
		
		Curso curso = cursoService.buscarPorId(alunoDto.getId_curso());
		
		AlunoCurso alunoCurso = alunoCursoService.salvar(aluno,curso);
		
		response.setData(alunoCurso);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
			
	}
	
	
	public ResponseEntity<Response<Pessoa>> litarPorId(long id){
		return null;
	}
	
	
	public ResponseEntity<Response<Pessoa>> atualizar(long id, AlunoDto alunoDto){
		return null;
		
	}
	
	 
	public ResponseEntity<Response<Pessoa>> deletar(long id) {
		return null;
	}
	
	
	
}
