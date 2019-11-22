package com.consultoria.ergogymbatch.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consultoria.ergogymbatch.model.Empresa;
import com.consultoria.ergogymbatch.service.EmpresaService;

@RestController

@RequestMapping(value = "/empresa")
public class EmpresaController {

	@Autowired
	private EmpresaService empresaService;

	@PostMapping
	public ResponseEntity<Empresa> create(@RequestBody Empresa empresa) {
		Empresa empresaReturn = empresaService.save(empresa);	
		return ResponseEntity.ok().body(empresaReturn);
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<Empresa> findById(@PathVariable("id") int id) {
		return empresaService.findOne(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Empresa> update(@PathVariable("id") int id, @RequestBody Empresa empresa) {
		return empresaService.findOne(id).map(record -> {
			record.setRazaoSocial(empresa.getRazaoSocial());
			record.setNomeFantasia(empresa.getNomeFantasia());
			record.setCnpj(empresa.getCnpj());
			record.setIndIEIsento(empresa.getIndIEIsento());
			record.setInscricaoEstadual(empresa.getInscricaoEstadual());
			record.setCelular(empresa.getCelular());
			record.setTelefone(empresa.getTelefone());
			record.setCep(empresa.getCep());
			record.setEndereco(empresa.getEndereco());
			record.setNumero(empresa.getNumero());
			record.setComplemento(empresa.getComplemento());
			record.setBairro(empresa.getBairro());
			record.setCidade(empresa.getCidade());
			record.setUf(empresa.getUf());
			record.setReferencia(empresa.getReferencia());
			record.setObservacao(empresa.getObservacao());
			Empresa updated = empresaService.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable int id) {
		return empresaService.findOne(id).map(record -> {
			empresaService.delete(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

	//Listagem das Empresas; 
	@GetMapping
	public List<Empresa> findAll() {
			return empresaService.findAll();
	}
	
}
