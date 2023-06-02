package com.nelioalves.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.entities.Produto;
import com.nelioalves.cursomc.repositories.ProdutoRepository;
import com.nelioalves.cursomc.services.exception.ObjectNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto buscar(Long id) {
		return produtoRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Produto não encontrado"));
	}
	
	public List<Produto> listar() {
		return produtoRepository.findAll();
	}
	
	public List<Produto> listarPorCategoria(Long id) {
		List<Produto> list = produtoRepository.findByCat(id);
		list.forEach(e -> System.out.println(e.getNome()));
		return list;
	}
	
	public Page<Produto> findAllWithCategoria(Pageable page) {
		return produtoRepository.findAllWithCategoria(page);
	}
}
