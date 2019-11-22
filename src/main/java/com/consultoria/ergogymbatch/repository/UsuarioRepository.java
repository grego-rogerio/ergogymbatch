package com.consultoria.ergogymbatch.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.consultoria.ergogymbatch.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	@Query("select u from Usuario u where u.login = :login")
	Optional<Usuario> findByLogin(String login);
}
