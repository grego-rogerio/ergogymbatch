package com.consultoria.ergogymbatch.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.consultoria.ergogymbatch.model.Setor;
import com.consultoria.ergogymbatch.repository.SetorRepository;

@Service
public class SetorService {

	@Autowired
	private SetorRepository setorRepository;
	
	public List<Setor> findAll() {
		return setorRepository.findAll();
	}
	
	public Optional<Setor> findOne(Integer id) {
		return setorRepository.findById(id);
	}
	
	public Setor save(Setor setor) {
		return setorRepository.saveAndFlush(setor);
	}
	
	public void delete(Integer id) {
		setorRepository.deleteById(id);
	}
	
}
