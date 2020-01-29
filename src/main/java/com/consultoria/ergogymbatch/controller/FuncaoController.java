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

import com.consultoria.ergogymbatch.model.Funcao;
import com.consultoria.ergogymbatch.service.FuncaoService;

@RestController
@RequestMapping(value = "/funcao")
public class FuncaoController {

	@Autowired
	private FuncaoService funcaoService;

	@PostMapping
	public ResponseEntity<Funcao> create(@RequestBody Funcao funcao) {
		Funcao funcaoReturn = funcaoService.save(funcao);	
		return ResponseEntity.ok().body(funcaoReturn);
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<Funcao> findById(@PathVariable("id") int id) {
		return funcaoService.findOne(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PutMapping(value = "/{id}",
	        consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Funcao> update(@PathVariable("id") int id, @RequestBody Funcao funcao) {
		if (funcaoService.findOne(id).isPresent()) {
	        Funcao funcaoReturn = funcaoService.save(funcao);	
		return ResponseEntity.ok().body(funcaoReturn);
	    }
            return ResponseEntity.notFound().build();
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable int id) {
		return funcaoService.findOne(id).map(record -> {
			funcaoService.delete(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

	//Listagem das Funcoes; 
	@GetMapping
	public ResponseEntity<List<Funcao>> findAll() {
			return ResponseEntity.ok(funcaoService.findAll());
	}
	
}
