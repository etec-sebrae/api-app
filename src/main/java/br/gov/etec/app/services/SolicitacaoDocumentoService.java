package br.gov.etec.app.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
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
	
		
	public List<SolicitacaoDocumento> litar(){		
		List<SolicitacaoDocumento> solicitacoes = repositorySolicitacoes.findAll();		
		repositorySolicitacoes.flush();		
		return solicitacoes;		
	}
	
	public SolicitacaoDocumento cadastrar(SolicitacaoDocumentoDto dto, BindingResult result){
		if(result.hasErrors()) {
			return null;
		}
		
		Pessoa aluno = alunoService.buscarPorId(dto.getId_aluno());		
		Documento documento = documentoService.buscarPorId(dto.getId_documento());		
		Curso curso = cursoService.buscarPorId(dto.getId_curso()); 		
		
		SolicitacaoDocumento solicitacoes = repositorySolicitacoes.saveAndFlush(dto.transformaSolicitacoesDto(documento, aluno,curso));
		
		return solicitacoes;		
		
	}
	
	

}
