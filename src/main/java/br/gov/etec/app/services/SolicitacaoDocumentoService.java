package br.gov.etec.app.services;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import br.gov.etec.app.dtos.SolicitacaoDocumentoDto;
import br.gov.etec.app.entity.Curso;
import br.gov.etec.app.entity.Documento;
import br.gov.etec.app.entity.Pessoa;
import br.gov.etec.app.entity.SolicitacaoDocumento;
import br.gov.etec.app.repository.SolicitacaoDocumentoRepository;

@Service
public class SolicitacaoDocumentoService {
	
	@Autowired
	private SolicitacaoDocumentoRepository repositorySolicitacoes;
	
	@Autowired
	private AlunoService alunoService;
	
	@Autowired
	private DocumentoService documentoService;
	
	@Autowired
	private CursoService cursoService;
			
	public Page<SolicitacaoDocumento> listar(Pageable pageable){
		return repositorySolicitacoes.findAll(pageable);     
	}
	
	public SolicitacaoDocumento listarPorId(long id){			
        return repositorySolicitacoes.findById(id);        
    }				 	
	
	public SolicitacaoDocumento cadastrar(SolicitacaoDocumentoDto dto){	
		Pessoa aluno = alunoService.buscarPorId(dto.getId_aluno());		
		Documento documento = documentoService.buscarPorId(dto.getId_documento());		
		Curso curso = cursoService.buscarPorId(dto.getId_curso());		
		SolicitacaoDocumento solicitacoes = repositorySolicitacoes.save(dto.transformaSolicitacoesDto(documento, aluno,curso));		
		return solicitacoes;		
	}
	
	public SolicitacaoDocumento atualizar(long id, int status){		
		SolicitacaoDocumento solicitacaoData = repositorySolicitacoes.findById(id);	
		
		if(solicitacaoData == null) {
			return null;
		}		
		
		solicitacaoData.setStatus(status);
				
		return repositorySolicitacoes.save(solicitacaoData);	
		
			
	}
	

}
