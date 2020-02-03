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

import com.consultoria.ergogymbatch.model.EstudoErgonomico;
import com.consultoria.ergogymbatch.service.EstudoErgonomicoService;

@RestController
@RequestMapping(value = "/estudoErgonomico")
public class EstudoErgonomicoController {

	@Autowired
	private EstudoErgonomicoService estudoErgonomicoService;

	@PostMapping
	public ResponseEntity<EstudoErgonomico> create(@RequestBody EstudoErgonomico estudoErgonomico) {
		EstudoErgonomico estudoErgonomicoReturn = estudoErgonomicoService.save(estudoErgonomico);	
		return ResponseEntity.ok().body(estudoErgonomicoReturn);
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<EstudoErgonomico> findById(@PathVariable("id") int id) {
		return estudoErgonomicoService.findOne(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());

	}

	@PutMapping(value = "/{id}",
	        consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EstudoErgonomico> update(@PathVariable("id") int id, @RequestBody EstudoErgonomico estudoErgonomico) {
		if (estudoErgonomicoService.findOne(id).isPresent()) {
	        EstudoErgonomico estudoErgonomicoReturn = estudoErgonomicoService.save(estudoErgonomico);	
		return ResponseEntity.ok().body(estudoErgonomicoReturn);
	    }
            return ResponseEntity.notFound().build();
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable int id) {
		return estudoErgonomicoService.findOne(id).map(record -> {
			estudoErgonomicoService.delete(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

	//Listagem das EstudoErgonomicos; 
	@GetMapping
	public ResponseEntity<List<EstudoErgonomico>> findAll() {
			return ResponseEntity.ok(estudoErgonomicoService.findAll());
	}
	
}
