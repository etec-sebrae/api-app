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

import br.gov.etec.app.dtos.SolicitacaoDocumentoDto;
import br.gov.etec.app.entity.SolicitacaoDocumento;
import br.gov.etec.app.response.Response;
import br.gov.etec.app.services.SolicitacaoDocumentoService;

@RestController
@RequestMapping("/api/solicitacoes")
public class SolicitacaoDocumentoController {
	
	@Autowired
	private SolicitacaoDocumentoService service;
	
	@GetMapping
	public ResponseEntity<Response<List<LinkedHashMap<String,Object>>>> listar(){
		List<SolicitacaoDocumento> solicitacoes = service.litar();
		return null;
	}
	
	
	@PostMapping
	public ResponseEntity<Response<SolicitacaoDocumento>> cadastro(@RequestBody @Valid SolicitacaoDocumentoDto dto, BindingResult result ){
		SolicitacaoDocumento solicatacao = service.cadastrar(dto, result);
		return null;
	}

}
