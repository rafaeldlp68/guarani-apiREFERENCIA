package br.com.guarani.api.controller.form;

import java.util.List;

import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.guarani.api.model.AreaConhecimento;
import br.com.guarani.api.model.Usuario;

@Data
public class UsuarioCadastro {

	private String nome;

	private String email;
	private String senha;



	//metodo usado no cadastro de usuario
	public Usuario converterCadastro() {
		
		return new Usuario(nome, email, senha);

	}
	


}


