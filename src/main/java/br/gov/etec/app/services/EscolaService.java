package br.gov.etec.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import br.gov.etec.app.dtos.EscolaDto;
import br.gov.etec.app.entity.Escola;
import br.gov.etec.app.repository.EscolaRepository;

@Service
public class EscolaService {
	
	@Autowired
	private EscolaRepository escolaRepository;
	
	public Page<Escola> listar(Pageable pageable){
		return escolaRepository.findAll(pageable);
	}
		
	public Escola cadastro(EscolaDto escolaDto) {
		Escola escola = escolaRepository.save(escolaDto.transformaEscolaDto());		
		return escola;
	}
	
}
