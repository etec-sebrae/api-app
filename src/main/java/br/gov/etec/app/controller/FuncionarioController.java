package br.gov.etec.app.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.gov.etec.app.dtos.FuncionarioDto;
import br.gov.etec.app.entity.Pessoa;
import br.gov.etec.app.services.FuncionarioService;

@RestController
@RequestMapping("/api/operador")
public class FuncionarioController {
	
	@Autowired
	FuncionarioService service;
	
	@GetMapping
	public ResponseEntity<?> listarOperadores(){
		List<Pessoa> funcionarios = service.listar();
		return ResponseEntity.status(HttpStatus.OK).body(funcionarios);
	}
	
	@PostMapping
	public ResponseEntity<Pessoa> cadastroOperadores(@RequestBody @Valid FuncionarioDto funcionarioDto, BindingResult result){
		Pessoa funcionario = service.cadastrar(funcionarioDto,result);
		return ResponseEntity.status(HttpStatus.OK).body(funcionario);
	}
	

}
