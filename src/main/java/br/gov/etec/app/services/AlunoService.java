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

import br.gov.etec.app.authentication.PerfilEnum;
import br.gov.etec.app.dtos.AlunoDto;
import br.gov.etec.app.entity.Aluno;
import br.gov.etec.app.entity.Curso;
import br.gov.etec.app.entity.Login;
import br.gov.etec.app.repository.AlunoRepository;
import br.gov.etec.app.repository.CursoReposity;
import br.gov.etec.app.response.Response;
import br.gov.etec.app.security.senhaUtils;

@Service
public class AlunoService {
	@Autowired
	private AlunoRepository repository;
	
	@Autowired
	private CursoReposity repositoryCurso;
	
	@Autowired
	LoginService loginService;	
	
	
	
	public ResponseEntity<Response<List<LinkedHashMap<String,Object>>>> listar(){
		List<Aluno> aluno = new ArrayList<>();
		aluno = repository.findAll();	
		
		Response<List<LinkedHashMap<String,Object>>> response = new Response<>();
		
		List<LinkedHashMap<String,Object>> listaAlunos = new  ArrayList<>();
		
		for (Aluno aluno2 : aluno) {
			SimpleDateFormat d = new SimpleDateFormat();
			LinkedHashMap<String, Object> al = new LinkedHashMap<>();
			al.put("id", aluno2.getId());
			al.put("nome", aluno2.getNome());
			al.put("rg", aluno2.getRg());
			al.put("cpf", aluno2.getCpf());
			al.put("email", aluno2.getLogin().getEmail());
			al.put("data_nasc", d.format(aluno2.getData_nasc()));
			al.put("curso", aluno2.getCurso().getNome());
			listaAlunos.add(al);					
		}
		
		response.setData(listaAlunos);
						
		repository.flush();
		return ResponseEntity.ok(response);
	}

	
	public ResponseEntity<Response<LinkedHashMap<String, Object>>> cadastrar(AlunoDto alunoDto,BindingResult result){
		
		if(result.hasErrors()) {
			return errorResponse(result);			
		}
				
		String senha = senhaUtils.gerarBCrypt(alunoDto.getSenha());
		alunoDto.setSenha(senha);
		
		Curso curso = repositoryCurso.findById(alunoDto.getId_curso());
		
		PerfilEnum perfil = PerfilEnum.ROLE_USUARIO;
		Login login = new Login();
		login.setSenha(senha);
		login.setEmail(alunoDto.getEmail());
		login.setPerfil(perfil);
		
		Login logi = loginService.save(login);
		
		
		Aluno aluno = repository.save(alunoDto.transformaAlunoDto(curso,logi));
		
		LinkedHashMap<String, Object> map = new LinkedHashMap<>();
		
	
		SimpleDateFormat d = new SimpleDateFormat();
		
		map.put("id",aluno.getId());
		map.put("nome",aluno.getNome());
		map.put("rg",aluno.getRg());
		map.put("cpf",aluno.getCpf());
		map.put("email",aluno.getLogin().getEmail());
		map.put("data_nasc",d.format(aluno.getData_nasc()));
		map.put("curso", aluno.getCurso().getNome());
		
		Response<LinkedHashMap<String, Object>> response = new Response<>();
		response.setData(map);
		
		repository.flush();				
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
			
	}
	
	
	public ResponseEntity<Response<Aluno>> litarPorId(long id){
		Response<Aluno> response = new Response<>();
		
		Aluno aluno = repository.findById(id);
		
		if(aluno == null) {
			LinkedHashMap<String, Object> obErro = new LinkedHashMap<>();			
			obErro.put("defaultMessage", "aluno não localizado");			
			response.getErrors().add(obErro);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		
		response.setData(aluno);
		
		return ResponseEntity.ok(response);
	}
	
	
	public ResponseEntity<Response<Aluno>> atualizar(long id, AlunoDto alunoDto){
		Response<Aluno> response = new Response<>();
		Aluno alunoData = repository.findById(id);
		if(alunoData == null) {
			LinkedHashMap<String, Object> al = new LinkedHashMap<>();
			al.put("defaultMessage", "Aluno não localizado");
			response.getErrors().add(al);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		}
		
		if(alunoDto.getCpf() != null && alunoDto.getCpf() != "" ) {
			alunoData.setCpf(alunoDto.getCpf());
		}
		
		if(alunoDto.getData_nasc() != null) {
			
			alunoData.setData_nasc(alunoDto.getData_nasc());
		}
		
		if(alunoDto.getEmail() != null) {
			alunoData.getLogin().setEmail(alunoDto.getEmail());
		}
		
		if(alunoDto.getId_curso() != 0L ){
			Curso curso = repositoryCurso.findById(alunoDto.getId_curso());
			alunoData.setCurso(curso);
		}
		
		if(alunoDto.getNome()!= null) {
			alunoData.setNome(alunoDto.getNome());
		}
		
		if(alunoDto.getRg() != null) {
			alunoData.setRg(alunoDto.getRg());
		}
		
		if(alunoDto.getSenha() != null) {
			String senha = senhaUtils.gerarBCrypt(alunoDto.getSenha());
			alunoData.getLogin().setSenha(senha);
		}
		
		if(alunoDto.getMatricula() != 0L) {
			alunoData.setMatricula(alunoDto.getMatricula());
		}
		
		
		Aluno _aluno = repository.save(alunoData);
		response.setData(_aluno);
		return ResponseEntity.status(HttpStatus.OK).body(response);
		
	}
	
	 
	public ResponseEntity<Response<Aluno>> deletar(long id) {
		Response<Aluno> response = new Response<>();
		Aluno aluno = repository.findById(id);
		repository.flush();
		
		if(aluno == null) {
			LinkedHashMap<String, Object> al = new LinkedHashMap<>();
			al.put("defaultMessage", "aluno não localizado");
			response.getErrors().add(al);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		}
		
		repository.delete(aluno);
		repository.flush();
		response.setData(aluno);
		return ResponseEntity.noContent().build();
	}
	
	private ResponseEntity<Response<LinkedHashMap<String, Object>>> errorResponse(BindingResult result) {
		
		Response<LinkedHashMap<String, Object>> response = new Response<>();
		
		for (int i = 0; i < result.getErrorCount(); i++) {
			LinkedHashMap<String, Object> al = new LinkedHashMap<>();
			ObjectError erro = result.getFieldErrors().get(i);
			al.put("defaultMessage", erro.getDefaultMessage());
			al.put("field", result.getFieldErrors().get(i).getField());
			al.put("objectName", erro.getObjectName());				
			
			response.getErrors().add(al);
		}
		
		return ResponseEntity.badRequest().body(response);
	}
	
}
