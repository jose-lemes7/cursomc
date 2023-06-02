package com.nelioalves.cursomc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nelioalves.cursomc.entities.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

	@Query(
				value = """
						select c
						from Cidade c
						left join fetch c.estado
						"""
	)
	public List<Cidade> listar();
}
