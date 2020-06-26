package br.gov.etec.app.controller;

import java.util.LinkedHashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.etec.app.dtos.FuncionarioDto;
import br.gov.etec.app.response.Response;
import br.gov.etec.app.services.FuncionarioService;

@RestController
@RequestMapping("/api/operador")
public class FuncionarioController {
	
	@Autowired
	FuncionarioService service;
	
	@GetMapping
	public ResponseEntity<Response<List<LinkedHashMap<String,Object>>>> listarOperadores(){
		return service.listarOperadores();
	}
	
	@PostMapping
	public ResponseEntity<Response<LinkedHashMap<String, Object>>> cadastroOperadores(@RequestBody @Valid FuncionarioDto funcionarioDto, BindingResult result){
		return service.cadastraOperadores(funcionarioDto,result);
	}
	

}
