package br.gov.etec.app.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Response<T> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5287959098087149801L;
	
	private T data;
	private List<LinkedHashMap<String, Object>> errors;	

	
	public Response() {
		
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<LinkedHashMap<String, Object>> getErrors() {
		if ( this.errors == null ) {
			this.errors = new  ArrayList<>();
		}
		return errors;
	}

	public void setErrors(List<LinkedHashMap<String, Object>> erros) {
		this.errors = erros;
	}
		

}
