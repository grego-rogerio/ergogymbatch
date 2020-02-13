package com.consultoria.ergogymbatch.controller;

import java.util.List;
import java.util.Optional;

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
import com.consultoria.ergogymbatch.model.Setor;
import com.consultoria.ergogymbatch.service.SetorService;

@RestController
@RequestMapping(value = "/setor")
public class SetorController {

	@Autowired
	private SetorService setorService;

	@PostMapping
	public ResponseEntity<Setor> create(@RequestBody Setor setor) {
		Setor setorReturn = setorService.save(setor);	
		return ResponseEntity.ok().body(setorReturn);
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<Setor> findById(@PathVariable("id") int id) {
		return setorService.findOne(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PutMapping(value = "/{id}",
	        consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Setor> update(@PathVariable("id") int id, @RequestBody Setor setor) {
		if (setorService.findOne(id).isPresent()) {
	        Setor setorReturn = setorService.save(setor);	
		return ResponseEntity.ok().body(setorReturn);
	    }
            return ResponseEntity.notFound().build();
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable int id) {
		return setorService.findOne(id).map(record -> {
			setorService.delete(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

	//Listagem dos Setores; 
	@GetMapping
	public ResponseEntity<List<Setor>> findAll() {
		List<Setor> lista = setorService.findAll();
			return ResponseEntity.ok(lista);
	}
	
	/**
	 * Listagem dos Setores que tem Funcao associado; 
	 * @return
	 */
	@GetMapping(path = { "/funcao" })
	public ResponseEntity<List<Setor>> findSetorWithFuncao() {
		Optional<List<Setor>> setores = setorService.findSetorWithFuncao();
			if(setores.isPresent()) {
				return ResponseEntity.ok(setores.get());
				
			}else {
				return ResponseEntity.notFound().build();
			}
	}
	
}
