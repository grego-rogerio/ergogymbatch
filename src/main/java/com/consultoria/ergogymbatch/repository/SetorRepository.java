package com.consultoria.ergogymbatch.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.consultoria.ergogymbatch.model.Setor;

public interface SetorRepository extends JpaRepository<Setor, Integer>{

	@Query("select distinct s from Funcao f, Setor s where f.setor.id = s.id")
	Optional<List<Setor>> findSetorWithFuncao();
	
}
