package com.consultoria.ergogymbatch.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

	@PutMapping(value = "/{id}",
	        consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Empresa> update(@PathVariable("id") int id, @RequestBody Empresa empresa) {
		if (empresaService.findOne(id).isPresent()) {
	        Empresa empresaReturn = empresaService.save(empresa);	
		return ResponseEntity.ok().body(empresaReturn);
	    }
            return ResponseEntity.notFound().build();
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
	public ResponseEntity<List<Empresa>> findAll() {
			return ResponseEntity.ok(empresaService.findAll());
	}
	
}
