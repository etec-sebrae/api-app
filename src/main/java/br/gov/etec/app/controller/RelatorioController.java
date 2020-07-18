package br.gov.etec.app.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import br.gov.etec.app.dtos.RelatorioDto;
import br.gov.etec.app.entity.Relatorio;
import br.gov.etec.app.services.RelatorioService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/relatorio")
public class RelatorioController {
	
	@Autowired
	private RelatorioService service;
	
	@GetMapping
	public ResponseEntity<?> listar(Pageable pageable){	
		Page<Relatorio> relatorio = service.listar(pageable);
		return ResponseEntity.status(HttpStatus.OK).body(relatorio);		
	}
	
	@PostMapping
	public ResponseEntity<?> cadastro(@RequestBody @Valid RelatorioDto dto ){
		Relatorio relatorio = service.cadastrar(dto);
		return ResponseEntity.status(HttpStatus.OK).body(relatorio);
	}
	
	@ApiOperation(value = "Atualiza o status do relatorio ")
	@PutMapping("/{id_relatorio}")
	public ResponseEntity<?> atualizar(@PathVariable("id_relatorio") long id, @RequestBody  RelatorioDto RelatoriosDto){
		Relatorio status = service.atualizar(id,RelatoriosDto);
		return ResponseEntity.status(HttpStatus.OK).body(status);
	}
	
	@ApiOperation(value = "Realiza a busca de um Relatorio específico, passando por paramentro o ID ")
	@GetMapping("/{id}")
	public ResponseEntity<List<Relatorio>>listarPorId(@PathVariable long id){		
		List<Relatorio> relatorios = service.buscarPorId(id);		
		return ResponseEntity.status(HttpStatus.OK).body(relatorios);
	}
		
	
	
	
	

}
