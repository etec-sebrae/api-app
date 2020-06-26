package br.gov.etec.app.services;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import br.gov.etec.app.dtos.DocumentoDto;
import br.gov.etec.app.entity.Documento;
import br.gov.etec.app.repository.DocumentoRepository;
import br.gov.etec.app.response.Response;

@Service
public class DocumentoService {
	@Autowired 
	private DocumentoRepository repository;
	
	public ResponseEntity<Response<List<Documento>>> listar() {
		Response<List<Documento>> response = new Response<>();
		List<Documento> documentos =  repository.findAll();
		
		repository.findAll();
		
		response.setData(documentos);		
		return ResponseEntity.ok(response);			
	}
	
	
	public ResponseEntity<Response<Documento>> cadastrar(DocumentoDto documentoDto, BindingResult result) {
		if(result.hasErrors()) {
			return errorResponse(result);
		}
		
		Response<Documento> response = new Response<>();
		Documento documento = repository.save(documentoDto.tranformarDocumentoDto());
		
		response.setData(documento);		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
		
	}
	
	private ResponseEntity<Response<Documento>> errorResponse(BindingResult result) {
		
		Response<Documento> response = new Response<>();
		
		for (int i = 0; i < result.getErrorCount(); i++) {
			LinkedHashMap<String, Object> al = new LinkedHashMap<>();
			ObjectError erro = result.getFieldErrors().get(i);
			al.put("defaultMessage", erro.getDefaultMessage());
			al.put("field", result.getFieldErrors().get(i).getField());
			al.put("objectName", erro.getObjectName());				
			
			response.getErrors().add(al);
		}
		
		return ResponseEntity.badRequest().body(response);
	}
}
