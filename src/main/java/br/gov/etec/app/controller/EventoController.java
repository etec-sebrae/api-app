package br.gov.etec.app.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.gov.etec.app.dtos.EventoDto;
import br.gov.etec.app.entity.Evento;
import br.gov.etec.app.services.EventoService;

@RestController
@RequestMapping("/api/evento")
public class EventoController {
	
	@Autowired
	EventoService service;
	
	
	@GetMapping
	public ResponseEntity<?> consultar(Pageable pageable){
		 return ResponseEntity.status(HttpStatus.OK).body(service.consultar(pageable));
	}
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody @Valid EventoDto dto) {
		Evento evento = service.cadastrar(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(evento);
	}
	
	
	

}
