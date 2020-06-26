package br.gov.etec.app.authentication;

import org.springframework.stereotype.Component;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
	
	public void commence (HttpServletRequest request, HttpServletResponse response,AuthenticationException authException ) throws IOException {
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
				"Acesso negado. Você deve estar autenticado no sistema "
				+ "para acessar a URL solicitada." );
	}
}
