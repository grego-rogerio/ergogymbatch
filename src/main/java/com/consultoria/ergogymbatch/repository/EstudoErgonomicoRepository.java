package com.consultoria.ergogymbatch.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.consultoria.ergogymbatch.model.EstudoErgonomico;

public interface EstudoErgonomicoRepository extends JpaRepository<EstudoErgonomico, Integer>{

	@Query("select f from EstudoErgonomico f where f.empresa.id = :idEmpresa and f.setor.id = :idSetor and f.funcao.id = :idFuncao")
	Optional<List<EstudoErgonomico>> findAllFiltros(Integer idEmpresa,Integer idSetor, Integer idFuncao);
	
	@Query("select f from EstudoErgonomico f where f.empresa.id = :idEmpresa")
	Optional<List<EstudoErgonomico>> findEmpresaFiltros(Integer idEmpresa);
	
	@Query("select f from EstudoErgonomico f where f.empresa.id = :idEmpresa and f.setor.id = :idSetor")
	Optional<List<EstudoErgonomico>> findSetorEmpresaFiltros(Integer idEmpresa,Integer idSetor);
	
	
	
}
