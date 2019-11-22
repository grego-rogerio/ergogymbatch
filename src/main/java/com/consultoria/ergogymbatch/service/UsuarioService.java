package com.consultoria.ergogymbatch.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consultoria.ergogymbatch.model.Usuario;
import com.consultoria.ergogymbatch.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
	
	public Optional<Usuario> findOne(Integer id) {
		return usuarioRepository.findById(id);
	}
	
	public Optional<Usuario> findByLogin(String login) {
		return usuarioRepository.findByLogin(login);
	}
	
	public Usuario save(Usuario usuario) {
		return usuarioRepository.saveAndFlush(usuario);
	}
	
	public void delete(Integer id) {
		usuarioRepository.deleteById(id);
	}
}
