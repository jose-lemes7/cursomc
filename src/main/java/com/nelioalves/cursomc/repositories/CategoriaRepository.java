package com.nelioalves.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nelioalves.cursomc.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
