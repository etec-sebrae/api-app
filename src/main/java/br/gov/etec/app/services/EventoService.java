package br.gov.etec.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import br.gov.etec.app.dtos.EventoDto;
import br.gov.etec.app.entity.Evento;
import br.gov.etec.app.repository.EventoRepository;

@Service
public class EventoService {

	@Autowired
	private EventoRepository repository;
	
	public List<Evento> consultar() {
		List<Evento> eventos = repository.findAll();		
		repository.flush();
		return eventos;
	}
	
	
	public Evento cadastrar(EventoDto dto,BindingResult result) {
		if(result.hasErrors()) {							
			return null;
		}
		
		Evento evento = repository.saveAndFlush(dto.tranformaEventoDto());		
		return evento;
	}
	
		
	
	
}
