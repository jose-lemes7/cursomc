package com.nelioalves.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nelioalves.cursomc.entities.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
