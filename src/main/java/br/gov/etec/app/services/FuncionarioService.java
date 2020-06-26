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

import br.gov.etec.app.authentication.PerfilEnum;
import br.gov.etec.app.dtos.FuncionarioDto;
import br.gov.etec.app.entity.Funcionario;
import br.gov.etec.app.entity.Login;
import br.gov.etec.app.repository.FuncionarioRepository;
import br.gov.etec.app.response.Response;
import br.gov.etec.app.security.senhaUtils;

@Service
public class FuncionarioService {
	@Autowired
	private FuncionarioRepository repository;
	
	@Autowired
	LoginService loginService;
	
	public ResponseEntity<Response<List<LinkedHashMap<String,Object>>>> listarOperadores(){
		List<Funcionario> operador = new ArrayList<>();
		operador = repository.findAll();
		
		Response<List<LinkedHashMap<String,Object>>> response = new Response<>();
		
		List<LinkedHashMap<String, Object>> listaOperadores = new ArrayList<>();
				
		for (Funcionario operador2 : operador) {
			LinkedHashMap<String, Object> op = new LinkedHashMap<>();
			op.put("id", operador2.getId());
			op.put("nome", operador2.getNome());
			op.put("email", operador2.getLogin().getEmail());
			listaOperadores.add(op);
		}
		
		response.setData(listaOperadores);
		
		repository.flush();
		return ResponseEntity.ok(response);		
	}
	
	public ResponseEntity<Response<LinkedHashMap<String, Object>>> cadastraOperadores(FuncionarioDto funcionarioDto,  BindingResult result){
		if(result.hasErrors()) {
			return errorResponse(result);
		}
				
		String senha = senhaUtils.gerarBCrypt(funcionarioDto.getSenha());
		
		funcionarioDto.setSenha(senha);
		
		PerfilEnum perfil = PerfilEnum.ROLE_USUARIO;
		Login login = new Login();
		login.setSenha(senha);
		login.setEmail(funcionarioDto.getEmail());
		login.setPerfil(perfil);
		
		Login loginSaved = loginService.save(login);
		
		Funcionario operador = repository.save(funcionarioDto.tranformaOperadorDto(loginSaved));
		
		//Criando resposta de return
		LinkedHashMap<String, Object> map = new LinkedHashMap<>();		
		map.put("id", operador.getId());
		map.put("nome", operador.getNome());
		map.put("email", operador.getLogin().getEmail());
	
		
		Response<LinkedHashMap<String, Object>> response = new Response<>();
		response.setData(map);
		
		repository.flush();
				
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	
	private ResponseEntity<Response<LinkedHashMap<String, Object>>> errorResponse(BindingResult result) {
		
		Response<LinkedHashMap<String, Object>> response = new Response<>();
		
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
