package br.gov.etec.app.services;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import br.gov.etec.app.dtos.FuncionarioDto;
import br.gov.etec.app.entity.Usuario;
import br.gov.etec.app.enuns.PerfilEnum;
import br.gov.etec.app.repository.PessoaRepository;
import br.gov.etec.app.response.Response;
import br.gov.etec.app.security.senhaUtils;

@Service
public class FuncionarioService {
	@Autowired
	private PessoaRepository pessoaFuncionarioRepository;
	
	@Autowired
	UsuarioService loginService;
	
	public ResponseEntity<Response<List<LinkedHashMap<String,Object>>>> listarOperadores(){
		return null;	
	}
	
	public ResponseEntity<Response<LinkedHashMap<String, Object>>> cadastraOperadores(FuncionarioDto funcionarioDto,  BindingResult result){
		return null;
	}
	
	
	private ResponseEntity<Response<LinkedHashMap<String, Object>>> errorResponse(BindingResult result) {
		
		return null;
	}

}
