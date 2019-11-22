package com.consultoria.ergogymbatch.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.consultoria.ergogymbatch.model.Empresa;
import com.consultoria.ergogymbatch.repository.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	public List<Empresa> findAll() {
		return empresaRepository.findAll();
	}
	
	public Optional<Empresa> findOne(Integer id) {
		return empresaRepository.findById(id);
	}
	
	public Empresa save(Empresa empresa) {
		return empresaRepository.saveAndFlush(empresa);
	}
	
	public void delete(Integer id) {
		empresaRepository.deleteById(id);
	}
	
}
