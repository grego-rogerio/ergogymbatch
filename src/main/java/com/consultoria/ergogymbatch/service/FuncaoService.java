package com.consultoria.ergogymbatch.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.consultoria.ergogymbatch.model.Funcao;
import com.consultoria.ergogymbatch.model.Setor;
import com.consultoria.ergogymbatch.repository.FuncaoRepository;

@Service
public class FuncaoService {

	@Autowired
	private FuncaoRepository funcaoRepository;
	
	public List<Funcao> findAll() {
		return funcaoRepository.findAll();
	}
	
	public Optional<List<Funcao>> findByIdSetor(Integer id) {
		return funcaoRepository.findByIdSetor(id);
	}
	
	public Optional<Funcao> findOne(Integer id) {
		return funcaoRepository.findById(id);
	}
	
	public Funcao save(Funcao funcao) {
		return funcaoRepository.saveAndFlush(funcao);
	}
	
	public void delete(Integer id) {
		funcaoRepository.deleteById(id);
	}
	
}
