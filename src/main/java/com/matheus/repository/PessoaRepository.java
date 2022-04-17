package com.matheus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matheus.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
