package br.gov.etec.app.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<?>listar(){		
		List<Documento> documentos = documentoService.listar();		
		return ResponseEntity.status(HttpStatus.OK).body(documentos);	
	}
	
	@PostMapping
	public ResponseEntity<?> cadastar(@RequestBody @Valid DocumentoDto documentoDto){
		Documento documento =  documentoService.cadastrar(documentoDto);
		return ResponseEntity.status(HttpStatus.OK).body(documento);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> atualizar(@PathVariable long id, @RequestBody DocumentoDto dto){
		Documento documento = documentoService.atualizar(id,dto);
		if(documento == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("documento não localizado");
		}
		return ResponseEntity.status(HttpStatus.OK).body(documento);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleta(@PathVariable long id){
		if(documentoService.deleta(id)){
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("documento não localicado");
		
	}
}
