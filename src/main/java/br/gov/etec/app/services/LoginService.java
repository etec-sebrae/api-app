package br.gov.etec.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.etec.app.entity.Login;
import br.gov.etec.app.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired 
	LoginRepository repository;
	
	public Login save(Login login) {		
		Login loginSaved = repository.save(login);
		repository.flush();
		return loginSaved;
	}

}
