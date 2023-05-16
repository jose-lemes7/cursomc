package com.nelioalves.cursomc.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nelioalves.cursomc.entities.Categoria;
import com.nelioalves.cursomc.entities.Produto;
import com.nelioalves.cursomc.repositories.CategoriaRepository;
import com.nelioalves.cursomc.repositories.ProdutoRepository;

@Configuration
public class LocalData {

	@Bean
	CommandLineRunner initDataase(
			CategoriaRepository categoriaRepository,
			ProdutoRepository produtoRepository
			) {
		return (args) -> {
			Categoria c1 = new Categoria("cat 1");
			Categoria c2 = new Categoria("cat 2");
			Produto p1 = new Produto("p1", 1.0);
			Produto p2 = new Produto("p2", 2.0);
			
			categoriaRepository.save(c1);
			categoriaRepository.save(c2);
			
			produtoRepository.save(p1);
			produtoRepository.save(p2);
			
			p1.getCategorias().add(c1);
			p1.getCategorias().add(c2);
			
			produtoRepository.save(p1);
			
			p2.getCategorias().add(c2);
			
			produtoRepository.save(p2);
			
			
		};
	}
}
