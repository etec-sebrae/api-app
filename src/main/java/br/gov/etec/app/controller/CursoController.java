package br.gov.etec.app.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.gov.etec.app.dtos.CursoDto;
import br.gov.etec.app.entity.Curso;
import br.gov.etec.app.services.CursoService;

@RestController
@RequestMapping("/api/curso")
public class CursoController {
	
	@Autowired
	CursoService service;
	
	@GetMapping
	public ResponseEntity<?>  listaCursos() {		
		List<Curso> cursos = service.listarCursos();	
		return ResponseEntity.status(HttpStatus.OK).body(cursos);
	}
				
	@PostMapping
	public ResponseEntity<?> cadastrarCurso(@RequestBody @Valid CursoDto cursoDto, BindingResult result){
		Curso curso = service.cadastrarCurso(cursoDto, result);		
		return ResponseEntity.status(HttpStatus.OK).body(curso);
	}
	
		
}
