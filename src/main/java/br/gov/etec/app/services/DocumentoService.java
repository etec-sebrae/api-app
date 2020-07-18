package br.gov.etec.app.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
		
	public Documento cadastrar(DocumentoDto documentoDto) {		
		Documento documento = repository.saveAndFlush(documentoDto.tranformarDocumentoDto());		
		return documento;		
	}
		
	public Documento buscarPorId(long id){
		return repository.findById(id);
	}

	public Documento atualizar(long id, DocumentoDto dto){
		Documento documento = repository.findById(id);
		
		if(documento == null) {
			return null;
		}
		
		if(dto.getDescricao() != "") {
			documento.setDescricao(dto.getDescricao());
		};
		if(dto.getNome() != "") {
			documento.setNome(dto.getNome());
		};
				
		return repository.save(documento);
	}

	public boolean deleta(long id){
		
		Documento documento = repository.findById(id);
		
		if(documento == null ) {
			return false;
		}
		
		repository.delete(documento);
		
		return true;
	}
	
}
