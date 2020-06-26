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

import br.gov.etec.app.dtos.SolicitacoesDto;
import br.gov.etec.app.entity.Solicitacoes;
import br.gov.etec.app.response.Response;
import br.gov.etec.app.services.SolicitacoesService;

@RestController
@RequestMapping("/api/solicitacoes")
public class SolicitacoesController {
	
	@Autowired
	private SolicitacoesService service;
	
	@GetMapping
	public ResponseEntity<Response<List<LinkedHashMap<String,Object>>>> listar(){
		return service.litar();
	}
	
	
	@PostMapping
	public ResponseEntity<Response<Solicitacoes>> cadastro(@RequestBody @Valid SolicitacoesDto dto, BindingResult result ){
		return service.cadastrar(dto, result);
	}

}
