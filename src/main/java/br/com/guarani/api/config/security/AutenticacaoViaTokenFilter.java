package br.com.guarani.api.config.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.guarani.api.model.Usuario;
import br.com.guarani.api.repository.UsuarioRepository;

public class AutenticacaoViaTokenFilter extends OncePerRequestFilter{
	
	
	
	private TokenService tokenService;
	
	private UsuarioRepository repository;



	
	
	public AutenticacaoViaTokenFilter(TokenService tonkenService, UsuarioRepository repository) {
		this.tokenService = tonkenService;
		this.repository = repository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = recuperartoken(request);
		boolean valido = tokenService.isTokenValido(token);
		
		if(valido) {
			autenticarCliente(token);
		}
		
		
		filterChain.doFilter(request, response);
		
	}

	
	private void autenticarCliente(String token) {
		
		Long idUsuario = tokenService.getIdUsuario(token);
		Usuario usuario= repository.findById(idUsuario).get();
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario,null, usuario.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
	}

	private String recuperartoken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if(token == null|| token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;
		}
		return token.substring(7, token.length());
	}

	
	
	
	
}
