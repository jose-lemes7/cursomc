package com.nelioalves.cursomc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nelioalves.cursomc.entities.Produto;
import com.nelioalves.cursomc.services.CategoriaService;
import com.nelioalves.cursomc.services.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	CategoriaService categoriaService;
	
	@GetMapping
	List<Produto> listar() {
		return produtoService.listar();
	}
	
	@GetMapping("/{id}")
	Produto buscar(@PathVariable Long id) {
		return produtoService.buscar(id);
	}
	
	@GetMapping("/categoria/{id}")
	List<Produto> findAllByCategoria(@PathVariable Long id) {
//		Categoria cat = categoriaService.buscar(id);
		return produtoService.listarPorCategoria(id);
	}
	
	@GetMapping("/withCat")
	Page<Produto> findAllWithCategoria(Pageable page) {
		return produtoService.findAllWithCategoria(page);
	}
	
}
