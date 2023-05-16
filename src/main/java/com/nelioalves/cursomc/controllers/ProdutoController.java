package com.nelioalves.cursomc.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nelioalves.cursomc.entities.Produto;
import com.nelioalves.cursomc.repositories.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	private final ProdutoRepository produtoRepository;
	
	
	
	public ProdutoController(ProdutoRepository produtoRepository) {
		super();
		this.produtoRepository = produtoRepository;
	}

	@GetMapping
	List<Produto> findAll() {
		return produtoRepository.findAll();
	}
	
	@GetMapping("/withCat")
	Page<Produto> findAllWithCategoria(Pageable page) {
		Page<Produto> result = produtoRepository.findAllWithCategoria(page);
		return result;
	}
}
