package com.consultoria.ergogymbatch.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.consultoria.ergogymbatch.model.Funcao;

public interface FuncaoRepository extends JpaRepository<Funcao, Integer>{

	@Query("select f from Funcao f where f.setor.id = :id")
	Optional<List<Funcao>> findByIdSetor(Integer id);
	
}
