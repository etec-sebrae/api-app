package br.gov.etec.app.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import br.gov.etec.app.dtos.DocumentoDto;
import br.gov.etec.app.entity.Documento;
import br.gov.etec.app.repository.DocumentoRepository;

@Service
public class DocumentoService {
	@Autowired 
	private DocumentoRepository repository;
	
	public List<Documento> listar() {		
		List<Documento> documentos =  repository.findAll();		
		repository.findAll();		
		return documentos;			
	}
		
	public Documento cadastrar(DocumentoDto documentoDto, BindingResult result) {
		if(result.hasErrors()) {
			return null;
		}
		
		Documento documento = repository.saveAndFlush(documentoDto.tranformarDocumentoDto());		
		return documento;		
	}
		
	public Documento buscarPorId(long id){
		return repository.findById(id);
	}
	
}
