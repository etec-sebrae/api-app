package br.gov.etec.app.error;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;

import br.gov.etec.app.response.Response;

@ControllerAdvice
public class RestEceptionHandler implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8636625667447770653L;

	@ExceptionHandler({SQLException.class, DataIntegrityViolationException.class, ConstraintViolationException.class})
	protected ResponseEntity<Response<LinkedHashMap<String, Object>>> handleSqlExeption(ConstraintViolationException ex){
		
		//UnrecognizedPropertyException
		
		Response<LinkedHashMap<String, Object>> response = new Response<>();
		
		LinkedHashMap<String, Object> al = new LinkedHashMap<>();
		
		al.put("defaultMessage",ex.getMessage());
		al.put("SQLMenssage", ex.getSQLException().getMessage());
		al.put("SQLStatus ", ex.getSQLException().getSQLState());								
		response.getErrors().add(al);
				
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
	
	
	@ExceptionHandler(UnrecognizedPropertyException.class)
	protected ResponseEntity<Response<LinkedHashMap<String, Object>>> handleDefaultExeption( UnrecognizedPropertyException ex){
		Response<LinkedHashMap<String, Object>> response = new Response<>();
		
		LinkedHashMap<String, Object> al = new LinkedHashMap<>();
		
		al.put("defaultMessage",ex.getMessage());
		response.getErrors().add(al);
				
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
		
	
	@ExceptionHandler(InvalidFormatException.class)
	protected ResponseEntity<Response<LinkedHashMap<String, Object>>> handleInvalidFormat(InvalidFormatException ex){
		Response<LinkedHashMap<String, Object>> response = new Response<>();
		
		LinkedHashMap<String, Object> al = new LinkedHashMap<>();
				
		al.put("defaultMessage",ex.getMessage());
		al.put("type",ex.getTargetType());
		response.getErrors().add(al);
				
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
	
	@ExceptionHandler(JsonParseException.class)
	protected ResponseEntity<Response<LinkedHashMap<String, Object>>> handleJsonParseException(JsonParseException ex) {
		Response<LinkedHashMap<String, Object>> response = new Response<>();
		
		LinkedHashMap<String, Object> al = new LinkedHashMap<>();
		
		
		al.put("defaultMessage",ex.getOriginalMessage());
		response.getErrors().add(al);
				
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
	
			
}
