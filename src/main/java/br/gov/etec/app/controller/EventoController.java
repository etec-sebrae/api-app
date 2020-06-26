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

import br.gov.etec.app.dtos.EventoDto;
import br.gov.etec.app.entity.Evento;
import br.gov.etec.app.response.Response;
import br.gov.etec.app.services.EventoService;

@RestController
@RequestMapping("/api/evento")
public class EventoController {
	
	@Autowired
	EventoService service;
	
	
	@GetMapping
	public ResponseEntity<Response<List<Evento>>> consultar(){
		return service.consultar();
	}
	
	@PostMapping
	public ResponseEntity<Response<Evento>> cadastrar(@RequestBody @Valid EventoDto dto,BindingResult result) {
		return service.cadastrar(dto,result);
	}
	
	
	

}
