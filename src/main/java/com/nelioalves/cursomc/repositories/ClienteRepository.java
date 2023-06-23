package com.nelioalves.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nelioalves.cursomc.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
