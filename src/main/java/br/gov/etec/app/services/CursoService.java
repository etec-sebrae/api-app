package br.gov.etec.app.services;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import br.gov.etec.app.dtos.CursoDto;
import br.gov.etec.app.entity.Curso;
import br.gov.etec.app.repository.CursoReposity;
import br.gov.etec.app.response.Response;

@Service
public class CursoService {
	
	@Autowired
	private CursoReposity repository;
	
	public ResponseEntity<Response<List<Curso>>> listarCursos(){		
		List<Curso> curso = repository.findAll();
		Response<List<Curso>> response = new Response<List<Curso>>();
		response.setData(curso);
		repository.flush();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	public ResponseEntity<Response<Curso>> incluirCurso(CursoDto cursoDto, BindingResult result){
					
		if(result.hasErrors()) {							
			return errorResponse(result);
		}
		
		Curso curso = repository.save(cursoDto.transformaCursoDto());		
		Response<Curso> response = new Response<Curso>();		
		response.setData(curso);
		repository.flush();
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	
	private ResponseEntity<Response<Curso>> errorResponse(BindingResult result) {
		
		Response<Curso> response = new Response<Curso>();
		
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
