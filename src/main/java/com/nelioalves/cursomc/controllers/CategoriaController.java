package com.nelioalves.cursomc.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nelioalves.cursomc.entities.Categoria;
import com.nelioalves.cursomc.repositories.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	private final CategoriaRepository categoriaRepository;
	
	public CategoriaController(CategoriaRepository categoriaRepository) {
		super();
		this.categoriaRepository = categoriaRepository;
	}

	@GetMapping
	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}
}
