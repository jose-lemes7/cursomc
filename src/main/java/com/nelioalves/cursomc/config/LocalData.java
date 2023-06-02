package com.nelioalves.cursomc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nelioalves.cursomc.entities.Categoria;
import com.nelioalves.cursomc.entities.Produto;
import com.nelioalves.cursomc.repositories.CategoriaRepository;
import com.nelioalves.cursomc.repositories.ProdutoRepository;

@Configuration
public class LocalData {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	@Autowired
	ProdutoRepository produtoRepository;
	

	@Bean
	CommandLineRunner initDataase() {
		return (args) -> {
			Categoria cat1 = new Categoria("Informática");
			Categoria cat2 = new Categoria("Escritório");
			
			
			Produto p1 = new Produto("Computador", 2000.00);
			Produto p2 = new Produto("Impressora", 800.00);
			Produto p3 = new Produto("Mouse", 80.00);
			
			p1.addCategorias(cat1);
			p2.addCategorias(cat1, cat2);
			p3.addCategorias(cat1);
			
			categoriaRepository.save(cat1);
			categoriaRepository.save(cat2);
			
			produtoRepository.save(p1);
			produtoRepository.save(p2);
			produtoRepository.save(p3);
			
		};
	}
	
}
