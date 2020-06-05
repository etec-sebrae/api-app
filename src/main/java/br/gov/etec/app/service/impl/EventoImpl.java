package br.gov.etec.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.etec.app.dtos.EventoDto;
import br.gov.etec.app.entity.EventoEntity;
import br.gov.etec.app.repository.EventoRepository;
import br.gov.etec.app.service.Evento;

@Service
public class EventoImpl implements Evento {

	@Autowired
	private EventoRepository repository;

	@Override
	public Boolean validarEvento(EventoDto evento) {
		if (evento.getStatus() == 1) {			
			return true;
		}
		return false;
	}
	
	public void salvarEvento(EventoEntity entity) {
		repository.save(entity);
	}
	
	public List<EventoEntity> listaEventos(){
		return repository.findAll();
	}

}
