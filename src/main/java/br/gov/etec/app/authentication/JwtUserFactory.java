package br.gov.etec.app.authentication;

import java.util.ArrayList ;
import java.util.List ;
import org.springframework.security.core.GrantedAuthority ;
import org.springframework.security.core.authority.SimpleGrantedAuthority ;

import br.gov.etec.app.entity.Login;

public class JwtUserFactory {
	
	private JwtUserFactory(){
	}
	
	public static JwtUser create(Login login) {
		
		return new JwtUser(login.getId(),login.getEmail(),login.getSenha(),
		mapToGrantedAuthorities(login.getPerfil()));
	}
	
	
	private static List<GrantedAuthority>mapToGrantedAuthorities(PerfilEnum perfilEnum){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(perfilEnum.toString()));
		return authorities ;
	}

}
