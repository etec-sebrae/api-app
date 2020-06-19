package br.gov.etec.app.controller;

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

import br.gov.etec.app.dtos.DocumentoDto;
import br.gov.etec.app.entity.Documento;
import br.gov.etec.app.response.Response;
import br.gov.etec.app.service.DocumentoService;

@RestController
@RequestMapping(value = "/api/documentos")
public class DocumentoController {
	
	@Autowired
	private DocumentoService documentoService;
	
	@GetMapping
	public ResponseEntity<Response<List<Documento>>>listar(){
		return documentoService.listar();
	}
	
	@PostMapping
	public ResponseEntity<Response<Documento>> cadastar(@RequestBody @Valid DocumentoDto documentoDto, BindingResult result){
		return documentoService.cadastrar(documentoDto,result);
	}
	
}
