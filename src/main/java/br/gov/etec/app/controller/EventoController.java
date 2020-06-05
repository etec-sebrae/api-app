package br.gov.etec.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.etec.app.dtos.EventoDto;
import br.gov.etec.app.entity.EventoEntity;
import br.gov.etec.app.mapping.EventoMapping;
import br.gov.etec.app.service.Evento;

@RestController
@RequestMapping("/evento")
public class EventoController {
	
	
@Autowired	
private Evento service;	

	@PostMapping("/cadastrar")
	public void cadastraAluno(@RequestBody EventoDto dto) {		
		if(service.validarEvento(dto)) {
			EventoEntity entity =  EventoMapping.fromEntity(dto);
			service.salvarEvento(entity);
			
		}		
	}
	
	@GetMapping("/listar")
	public List<EventoEntity> listaAlunos(){
		return service.listaEventos();
	}

}
