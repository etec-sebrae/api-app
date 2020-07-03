package br.gov.etec.app.error;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;

@ControllerAdvice
public class RestEceptionHandler implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8636625667447770653L;

	@ExceptionHandler({SQLException.class, DataIntegrityViolationException.class, ConstraintViolationException.class})
	protected ResponseEntity<?> handleSqlExeption(ConstraintViolationException ex){
		
		LinkedHashMap<String, Object> al = new LinkedHashMap<>();
				
		al.put("defaultMessage",ex.getMessage());
		al.put("SQLMenssage", ex.getSQLException().getMessage());
		al.put("SQLStatus ", ex.getSQLException().getSQLState());
									
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(al);
		
	}
	
	
	@ExceptionHandler(UnrecognizedPropertyException.class)
	protected ResponseEntity<?> handleDefaultExeption( UnrecognizedPropertyException ex){
				
		LinkedHashMap<String, Object> al = new LinkedHashMap<>();		
		al.put("defaultMessage",ex.getMessage());
		al.put("localizedMessage", ex.getLocalizedMessage());	
				
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(al);
	}
		
	
	@ExceptionHandler(InvalidFormatException.class)
	protected ResponseEntity<?> handleInvalidFormat(InvalidFormatException ex){			
		LinkedHashMap<String, Object> al = new LinkedHashMap<>();				
		al.put("defaultMessage",ex.getMessage());
		al.put("type",ex.getTargetType());
			
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(al);
	}
	
	@ExceptionHandler(JsonParseException.class)
	protected ResponseEntity<?> handleJsonParseException(JsonParseException ex) {		
		LinkedHashMap<String, Object> al = new LinkedHashMap<>();				
		al.put("defaultMessage",ex.getOriginalMessage());
						
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(al);
	}
	
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	private ResponseEntity<?> errorResponse(MethodArgumentNotValidException result) {		
		
		List<LinkedHashMap<String, Object>> listaErros  = new ArrayList<>();
		
		for (int i = 0; i < result.getBindingResult().getErrorCount(); i++) {
			LinkedHashMap<String, Object> error = new LinkedHashMap<>();			
			ObjectError erro = result.getBindingResult().getFieldErrors().get(i);	
			
			error.put("defaultMessage", erro.getDefaultMessage());
			error.put("field", result.getBindingResult().getFieldErrors().get(i).getField());
			error.put("objectName", erro.getObjectName());	
			
			listaErros.add(error);
		}
		
		return ResponseEntity.badRequest().body(listaErros);
	}
	
		
			
}
