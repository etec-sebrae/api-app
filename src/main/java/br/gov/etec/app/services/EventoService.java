package br.gov.etec.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import br.gov.etec.app.dtos.EventoDto;
import br.gov.etec.app.entity.Evento;
import br.gov.etec.app.repository.EventoRepository;

@Service
public class EventoService {

	@Autowired
	private EventoRepository repository;
	
	public Page<Evento> consultar(Pageable pageable) {	
		Page<Evento> eventos = repository.findAll(pageable);
		repository.flush();
		return eventos ;	
	}
	
	
	public Evento cadastrar(EventoDto dto) {
				
		Evento evento = repository.saveAndFlush(dto.tranformaEventoDto());	
		repository.flush();
		return evento;
	}
	
		
	
	
}
