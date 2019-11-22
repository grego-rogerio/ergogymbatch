package com.consultoria.ergogymbatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultoria.ergogymbatch.model.Empresa;
import com.consultoria.ergogymbatch.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{

}
