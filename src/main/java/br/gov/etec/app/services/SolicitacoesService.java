package br.gov.etec.app.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import br.gov.etec.app.dtos.SolicitacoesDto;
import br.gov.etec.app.entity.Aluno;
import br.gov.etec.app.entity.Documento;
import br.gov.etec.app.entity.Solicitacoes;
import br.gov.etec.app.repository.AlunoRepository;
import br.gov.etec.app.repository.DocumentoRepository;
import br.gov.etec.app.repository.SolicitacoesRepository;
import br.gov.etec.app.response.Response;

@Service
public class SolicitacoesService {
	
	@Autowired
	private SolicitacoesRepository repositorySolicitacoes;
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private DocumentoRepository documentoRepository;
	
	public ResponseEntity<Response<List<LinkedHashMap<String,Object>>>> litar(){
		Response<List<LinkedHashMap<String,Object>>> response = new Response<>();
		
		List<Solicitacoes> solicitacoes = repositorySolicitacoes.findAll();
		
		List<LinkedHashMap<String,Object>> listaSolicitacoes = new  ArrayList<>();
		
		for (Solicitacoes solicitacoes2 : solicitacoes) {
			SimpleDateFormat d = new SimpleDateFormat();
			LinkedHashMap<String, Object> al = new LinkedHashMap<>();
			al.put("id", solicitacoes2.getId());
			al.put("Aluno", solicitacoes2.getAluno().getNome());
			al.put("Documento", solicitacoes2.getDocumento().getDescricao());
			al.put("Status", solicitacoes2.getStatus());
			al.put("Data", d.format(solicitacoes2.getData_solicitacao()));
			listaSolicitacoes.add(al);	
		}
		
		
		response.setData(listaSolicitacoes);
		
		repositorySolicitacoes.flush();
		return ResponseEntity.ok(response);
		
	}
	
	public ResponseEntity<Response<Solicitacoes>> cadastrar(SolicitacoesDto dto, BindingResult result){
		if(result.hasErrors()) {
			return errorResponse(result);
		}
		
		Aluno aluno = alunoRepository.findById(dto.getId_aluno());
		alunoRepository.flush();
		
		if(aluno == null) {
			Response<Solicitacoes> response = new Response<>();
			LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
			map.put("defaultMessage", "id aluno invalido");
			response.getErrors().add(map);
			return ResponseEntity.badRequest().body(response);
		}
		
		Documento documento = documentoRepository.findById(dto.getId_documento());
		documentoRepository.flush();
		
		if(documento == null) {
			Response<Solicitacoes> response = new Response<>();
			LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
			map.put("defaultMessage", " id documento invalido");
			response.getErrors().add(map);
			return ResponseEntity.badRequest().body(response);
		}
		
		
		
		Solicitacoes solicitacoes = repositorySolicitacoes.save(dto.transformaSolicitacoesDto(documento, aluno));
		repositorySolicitacoes.findAll();
		
		Response<Solicitacoes> response = new Response<>();
		
		
		response.setData(solicitacoes);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
		
		
	}
	
	private ResponseEntity<Response<Solicitacoes>> errorResponse(BindingResult result) {
		
		Response<Solicitacoes> response = new Response<>();
		
		for (int i = 0; i < result.getErrorCount(); i++) {
			LinkedHashMap<String, Object> al = new LinkedHashMap<>();
			ObjectError erro = result.getFieldErrors().get(i);
			al.put("defaultMessage", erro.getDefaultMessage());
			al.put("field", result.getFieldErrors().get(i).getField());
			al.put("objectName", erro.getObjectName());				
			
			response.getErrors().add(al);
		}
		
		return ResponseEntity.badRequest().body(response);
	}

}
