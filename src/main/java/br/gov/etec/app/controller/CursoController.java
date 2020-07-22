package br.gov.etec.app.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		System.out.println(cursos.get(1));
		return ResponseEntity.status(HttpStatus.OK).body(cursos);
	}
				
	@PostMapping
	public ResponseEntity<?> cadastrarCurso(@RequestBody @Valid CursoDto cursoDto){
		Curso curso = service.cadastrarCurso(cursoDto);		
		return ResponseEntity.status(HttpStatus.OK).body(curso);
	}
	
	
	@PutMapping("{id}")
	public ResponseEntity<?> atualizar(@PathVariable long id, @RequestBody CursoDto dto){
		Curso curso = service.atualizar(id,dto);
		
		if(curso == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("documento não localizado");
		}
		return ResponseEntity.status(HttpStatus.OK).body(curso);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleta(@PathVariable long id){
		if(service.deleta(id)){
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("documento não localicado");
	}
	
		
}
