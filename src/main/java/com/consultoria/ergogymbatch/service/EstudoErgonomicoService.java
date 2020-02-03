package com.consultoria.ergogymbatch.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.consultoria.ergogymbatch.model.EstudoErgonomico;
import com.consultoria.ergogymbatch.repository.EstudoErgonomicoRepository;

@Service
public class EstudoErgonomicoService {

	@Autowired
	private EstudoErgonomicoRepository estudoErgonomicoRepository;
	
	public List<EstudoErgonomico> findAll() {
		return estudoErgonomicoRepository.findAll();
	}
	
	public Optional<EstudoErgonomico> findOne(Integer id) {
		return estudoErgonomicoRepository.findById(id);
	}
	
	public EstudoErgonomico save(EstudoErgonomico estudoErgonomico) {
		return estudoErgonomicoRepository.saveAndFlush(estudoErgonomico);
	}
	
	public void delete(Integer id) {
		estudoErgonomicoRepository.deleteById(id);
	}
	
}
