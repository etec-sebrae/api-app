package br.gov.etec.app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.etec.app.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.gov.etec.app.authentication.JwtUserFactory;
import br.gov.etec.app.entity.Usuario;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService{
		
	@Autowired
	UsuarioRepository loginRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> login = loginRepository.findByEmail(username);
		loginRepository.flush();
		System.out.println(login.isPresent());
		if (!login.isPresent()) {
			throw new UsernameNotFoundException("Email não encontrado.");
		}
		return JwtUserFactory.create(login.get());
		
	}
	
}
