package br.gov.etec.app.controller;


import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.gov.etec.app.dtos.EscolaDto;
import br.gov.etec.app.entity.Escola;
import br.gov.etec.app.services.EscolaService;

@RestController
@RequestMapping(value = "/api/escola")
public class EscolaController {
	
	@Autowired
	private EscolaService escolaService;	
	
	@GetMapping
	public ResponseEntity<?> listar(Pageable pageable){
		Page<Escola> escolas = escolaService.listar(pageable);		
		return ResponseEntity.status(HttpStatus.OK).body(escolas);
	}
	
	@PostMapping
	public ResponseEntity<?> cadastro(@RequestBody @Valid EscolaDto escolaDto){
		Escola escola =  escolaService.cadastro(escolaDto);		
		return ResponseEntity.status(HttpStatus.CREATED).body(escola);
	}

}
