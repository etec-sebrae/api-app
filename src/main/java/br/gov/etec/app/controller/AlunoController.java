package br.gov.etec.app.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.gov.etec.app.dtos.AlunoDto;
import br.gov.etec.app.entity.AlunoCurso;
import br.gov.etec.app.entity.Pessoa;
import br.gov.etec.app.services.AlunoService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {
	
		
	@Autowired
	AlunoService service;
	
	@ApiOperation(value = "Retorna uma lista com todos os alunos cadastrados na base de dados")
	@GetMapping()
	public ResponseEntity<?> listar(Pageable pageable){		
		List<Pessoa> alunos = service.listar(pageable);		
		return ResponseEntity.status(HttpStatus.OK).body(alunos);		
	}
	
	@ApiOperation(value = "Realiza o cadastro de um novo aluno e retorno os dasdos do aluno")
	@PostMapping()
	public ResponseEntity<?> cadastrar(@RequestBody @Valid AlunoDto alunoDto) {
				
		AlunoCurso aluno =  service.cadastrar(alunoDto);	
		return ResponseEntity.status(HttpStatus.OK).body(aluno);
	}
	
	@ApiOperation(value = "Realiza a busca de um aluno específico, passando por paramentro o ID ")
	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> listarPorId(@PathVariable long id){		
		Pessoa aluno = service.buscarPorId(id);		
		return ResponseEntity.status(HttpStatus.OK).body(aluno);
	}
		
		
}
