package com.nelioalves.cursomc.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nelioalves.cursomc.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	@Query(
			value = """
					select p
					from Produto p
					left join fetch p.categorias
					""",
			countQuery = """
					select count(p)
					from Produto p
					"""
			)
	public Page<Produto>findAllWithCategoria(Pageable page) ;

	@Query(
			value = """
					select p
					from Produto p
					left join fetch p.categorias c
					where c.id = ?1
					"""
	)	
	List<Produto> findByCat(Long id);
}
