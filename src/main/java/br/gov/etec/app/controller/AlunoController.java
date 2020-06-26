package br.gov.etec.app.controller;

import java.util.LinkedHashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.etec.app.dtos.AlunoDto;
import br.gov.etec.app.entity.Aluno;
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
	public ResponseEntity<Response<List<LinkedHashMap<String,Object>>>> listar( ){		
		return service.listar();
	}
	
	@ApiOperation(value = "Realiza o cadastro de um novo aluno e retorno os dasdos do aluno")
	@PostMapping()
	public ResponseEntity<Response<LinkedHashMap<String, Object>>> cadastrar(@RequestBody @Valid AlunoDto alunoDto,BindingResult result) {
		return service.cadastrar(alunoDto,result);			 
	}
	
	@ApiOperation(value = "Realiza a busca de um aluno específico, passando por paramentro o ID ")
	@GetMapping("/{id}")
	public ResponseEntity<Response<Aluno>> listarPorId(@PathVariable long id){
		return service.litarPorId(id);
	}
	
	
	@ApiOperation(value = "Atualiza os dados de um aluno passando por paramentro o ID, e no corpo os dados a serem atualizados ")
	@PutMapping("/{id}")
	public ResponseEntity<Response<Aluno>> atualizar(@PathVariable("id") long id, @RequestBody  AlunoDto alunoDto){
		return service.atualizar(id,alunoDto);
	}
	
	@ApiOperation(value = "Deletar aluno passando por paramentro o ID")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Response<Aluno>> deletar(@PathVariable long id){
		 return service.deletar(id);
	}
	
		
}
