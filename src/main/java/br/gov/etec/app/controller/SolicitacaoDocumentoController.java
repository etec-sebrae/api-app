package br.gov.etec.app.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.gov.etec.app.dtos.SolicitacaoDocumentoDto;
import br.gov.etec.app.entity.SolicitacaoDocumento;
import br.gov.etec.app.services.SolicitacaoDocumentoService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/solicitacoes")
public class SolicitacaoDocumentoController {
	
	@Autowired
	private SolicitacaoDocumentoService service;
	
	@GetMapping
	public ResponseEntity<?> listar(Pageable pageable){	
		return ResponseEntity.status(HttpStatus.OK).body(service.listar(pageable));		
	}
	
	@PostMapping
	public ResponseEntity<?> cadastro(@RequestBody @Valid SolicitacaoDocumentoDto dto){
		SolicitacaoDocumento solicatacao = service.cadastrar(dto);
		if(solicatacao == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("solicitação não localizada");
		}
		return ResponseEntity.status(HttpStatus.OK).body(solicatacao);
	}
	
	@ApiOperation(value = "Atualiza os dados de uma solicitacao por paramentro o ID, e no corpo os dados a serem atualizados ")
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable("id") long id, @RequestBody  int status){
		SolicitacaoDocumento solicatacao = service.atualizar(id,status);
		return ResponseEntity.status(HttpStatus.OK).body(solicatacao);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getForAluno(@PathVariable("id") long id){
		List<SolicitacaoDocumento> solicatacao = service.getForAluno(id);
		if(solicatacao == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("solicitação não localizada");
		}
		return ResponseEntity.status(HttpStatus.OK).body(solicatacao);
		
	}

}
