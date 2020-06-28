package br.gov.etec.app.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.etec.app.dtos.AlunoDto;
import br.gov.etec.app.entity.AlunoCurso;
import br.gov.etec.app.entity.Pessoa;
import br.gov.etec.app.response.Response;
import br.gov.etec.app.services.AlunoService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {
	
		
	@Autowired
	AlunoService service;
	
	@ApiOperation(value = "Retorna uma lista com todos os alunos cadastrados na base de dados")
	@GetMapping()
	public ResponseEntity<Response<List<Pessoa>>> listar( ){
		
		List<Pessoa> alunos = service.listar();
		
		return null;
		
	}
	
	@ApiOperation(value = "Realiza o cadastro de um novo aluno e retorno os dasdos do aluno")
	@PostMapping()
	public ResponseEntity<Response<AlunoCurso>> cadastrar(@RequestBody @Valid AlunoDto alunoDto,BindingResult result) {
		AlunoCurso aluno =  service.cadastrar(alunoDto,result);	
		return null;
	}
	
	@ApiOperation(value = "Realiza a busca de um aluno específico, passando por paramentro o ID ")
	@GetMapping("/{id}")
	public ResponseEntity<Response<Pessoa>> listarPorId(@PathVariable long id){
		
		Pessoa aluno = service.buscarPorId(id);
		
		return null;
	}
		
		
}
