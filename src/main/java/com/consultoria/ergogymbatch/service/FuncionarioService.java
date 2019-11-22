package com.consultoria.ergogymbatch.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consultoria.ergogymbatch.model.Funcionario;
import com.consultoria.ergogymbatch.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public List<Funcionario> findAll() {
		return funcionarioRepository.findAll();
	}
	
	public Optional<Funcionario> findOne(Integer id) {
		return funcionarioRepository.findById(id);
	}
	
	public Funcionario save(Funcionario funcionario) {
		return funcionarioRepository.saveAndFlush(funcionario);
	}
	
	public void delete(Integer id) {
		funcionarioRepository.deleteById(id);
	}
}
