package br.gov.etec.app.services;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import br.gov.etec.app.dtos.EventoDto;
import br.gov.etec.app.entity.Evento;
import br.gov.etec.app.repository.EventoRepository;
import br.gov.etec.app.response.Response;

@Service
public class EventoService {

	@Autowired
	private EventoRepository repository;
	
	public ResponseEntity<Response<List<Evento>>> consultar() {
		List<Evento> eventos = repository.findAll();
		Response<List<Evento>> response = new Response<>();
		response.setData(eventos);
		repository.flush();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	
	public ResponseEntity<Response<Evento>> cadastrar(EventoDto dto,BindingResult result) {
		if(result.hasErrors()) {							
			return errorResponse(result);
		}
		
		Evento evento = repository.save(dto.tranformaEventoDto());
		Response<Evento> response = new Response<>();
		response.setData(evento);
		
		repository.flush();
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	private ResponseEntity<Response<Evento>> errorResponse(BindingResult result) {
		
		Response<Evento> response = new Response<>();
		
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
