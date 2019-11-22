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

import com.consultoria.ergogymbatch.model.Funcionario;
import com.consultoria.ergogymbatch.service.FuncionarioService;

@RestController

@RequestMapping(value = "/funcionario")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;

	@PostMapping
	public ResponseEntity<Funcionario> create(@RequestBody Funcionario funcionario) {
		Funcionario funcionarioReturn = funcionarioService.save(funcionario);
		return ResponseEntity.ok().body(funcionarioReturn);
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<Funcionario> findById(@PathVariable("id") int id) {
		return funcionarioService.findOne(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Funcionario> update(@PathVariable("id") int id, @RequestBody Funcionario funcionario) {
		return funcionarioService.findOne(id).map(record -> {
			record.setNome(funcionario.getNome());
			record.setCargo(funcionario.getCargo());
			record.setSetor(funcionario.getSetor());
			record.setDataNascimento(funcionario.getDataNascimento());
			record.setCpf(funcionario.getCpf());
			record.setCelular(funcionario.getCelular());
			record.setTelefone(funcionario.getTelefone());
			record.setCep(funcionario.getCep());
			record.setEndereco(funcionario.getEndereco());
			record.setNumero(funcionario.getNumero());
			record.setComplemento(funcionario.getComplemento());
			record.setBairro(funcionario.getBairro());
			record.setCidade(funcionario.getCidade());
			record.setUf(funcionario.getUf());
			record.setReferencia(funcionario.getReferencia());
			record.setObservacao(funcionario.getObservacao());
			record.setEmpresa(funcionario.getEmpresa());
			Funcionario updated = funcionarioService.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable int id) {
		return funcionarioService.findOne(id).map(record -> {
			funcionarioService.delete(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

	//Listagem das Funcionarios; 
	@GetMapping
	public List<Funcionario> findAll() {
			return funcionarioService.findAll();
	}
}
