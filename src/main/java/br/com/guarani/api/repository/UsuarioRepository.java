package br.com.guarani.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.guarani.api.model.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	
	Optional<Usuario> findByEmail(String email);
	
	List<Usuario> findByNomeContains(String nome);

	
}














