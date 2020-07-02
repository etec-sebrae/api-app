package br.gov.etec.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.etec.app.entity.Usuario;
import br.gov.etec.app.enuns.PerfilEnum;
import br.gov.etec.app.repository.UsuarioRepository;
import br.gov.etec.app.security.senhaUtils;

@Service
public class UsuarioService {
	
	@Autowired 
	UsuarioRepository repository;
	
	public Usuario save(Usuario login) {		
		Usuario loginSaved = repository.save(login);
		repository.flush();
		return loginSaved;
	}

	public Usuario criarUsuarioAluno(String email, String senha) {
		
		String senhaEncoder = senhaUtils.gerarBCrypt(senha);
		
		Usuario entity = new Usuario(email,senhaEncoder,PerfilEnum.ROLE_USUARIO);
				
		Usuario usuario = repository.save(entity);
		
		return usuario;		
	}
	
	public Usuario criarUsuarioFuncionario(String email, String senha) {
		
		String senhaEncoder = senhaUtils.gerarBCrypt(senha);
		
		Usuario entity = new Usuario(email,senhaEncoder,PerfilEnum.ROLE_ADMIN);
				
		Usuario usuario = repository.save(entity);
		
		return usuario;		
	}

}
