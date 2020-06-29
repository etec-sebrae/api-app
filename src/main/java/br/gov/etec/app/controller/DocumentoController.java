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
import br.gov.etec.app.dtos.DocumentoDto;
import br.gov.etec.app.entity.Documento;
import br.gov.etec.app.services.DocumentoService;

@RestController
@RequestMapping(value = "/api/documentos")
public class DocumentoController {
	
	@Autowired
	private DocumentoService documentoService;
	
	@GetMapping
	public ResponseEntity<List<Documento>>listar(){		
		List<Documento> documentos = documentoService.listar();		
		return ResponseEntity.status(HttpStatus.OK).body(documentos);	
	}
	
	@PostMapping
	public ResponseEntity<?> cadastar(@RequestBody @Valid DocumentoDto documentoDto, BindingResult result){
		Documento documento =  documentoService.cadastrar(documentoDto,result);
		return ResponseEntity.status(HttpStatus.OK).body(documento);
	}
	
}
