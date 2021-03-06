package br.gov.etec.app.controller;

import java.util.LinkedHashMap;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.gov.etec.app.authentication.JwtTokenUtil;
import br.gov.etec.app.dtos.JwtAuthenticationDto;
import br.gov.etec.app.dtos.TokenDto;
import br.gov.etec.app.entity.Pessoa;
import br.gov.etec.app.enuns.TipoEnum;
import br.gov.etec.app.repository.PessoaRepository;
import br.gov.etec.app.response.Response;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthenticationController {

	private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);
	private static final String TOKEN_HEADER = "Authorization";
	private static final String BEARER_PREFIX = "Bearer";
	
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	/**
	* Gera e retorna um novo token JWT.
	*
	* @param authenticationDto
	* @param result
	* @return ResponseEntity<Response<TokenDto>>
	* @throws AuthenticationException
	*/
	
	@PostMapping()
	public ResponseEntity<?> gerarTokenJwtOperador(@Valid @RequestBody JwtAuthenticationDto authenticationDto) throws AuthenticationException {
			
		log.info("Gerando Token para o email {}",authenticationDto.getEmail());	
		
		Authentication authentication = authenticationManager.authenticate( 
				new UsernamePasswordAuthenticationToken(
						authenticationDto.getEmail(), authenticationDto.getSenha()
				)
		);
		
		SecurityContextHolder.getContext().setAuthentication(authentication);		
		UserDetails userDetails = userDetailsService.loadUserByUsername(
				authenticationDto.getEmail()
		);				
		
		String token = jwtTokenUtil.obterToken(userDetails);		
		Pessoa pessoa = pessoaRepository.findByEmail(authenticationDto.getEmail());	
		
		if(pessoa.getTipo() == TipoEnum.ALUNO) {
			
			return ResponseEntity.ok(new TokenDto(token,pessoa));
		}
		
				
		return ResponseEntity.ok(new TokenDto(token,pessoa));				
	}
	
	
		
	
	/**
	* Gera um novo token com uma nova data de expiração.
	*
	* @param request
	* @return ResponseEntity<Response<TokenDto>>
	*/
	
	@PostMapping ( value = "/refresh" )
	public ResponseEntity<Response<TokenDto>> gerarRefreshTokenJwt(HttpServletRequest request ) {
		log.info("Gerando refresh token JWT.");
		Response<TokenDto>response = new Response<TokenDto>();
		Optional<String> token = Optional.ofNullable(request.getHeader(TOKEN_HEADER));
		if (token.isPresent() && token.get().startsWith(BEARER_PREFIX)){
			token = Optional.of(token.get().substring(7));
		}
		
		if(!token.isPresent()){		
			LinkedHashMap<String, Object> al = new LinkedHashMap<>();
			al.put("defaultMessage", "Token não informado.");
			response.getErrors().add(al);
			
		} else if(!jwtTokenUtil.tokenValido(token.get())){
			LinkedHashMap<String, Object> al = new LinkedHashMap<>();
			al.put("defaultMessage", "Token inválido ou expirado.");
			response.getErrors().add(al);
		}
		if (!response.getErrors().isEmpty()){
			return ResponseEntity.badRequest().body(response);
		}
		
		String refreshedToken = jwtTokenUtil.refreshToken(token.get());
		response.setData( new TokenDto(refreshedToken));
		
		return ResponseEntity.ok(response);
	}
	
}
