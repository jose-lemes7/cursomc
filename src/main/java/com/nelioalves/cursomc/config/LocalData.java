package com.nelioalves.cursomc.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nelioalves.cursomc.entities.Categoria;
import com.nelioalves.cursomc.entities.Cidade;
import com.nelioalves.cursomc.entities.Cliente;
import com.nelioalves.cursomc.entities.Endereco;
import com.nelioalves.cursomc.entities.Estado;
import com.nelioalves.cursomc.entities.Produto;
import com.nelioalves.cursomc.entities.enums.TipoCliente;
import com.nelioalves.cursomc.repositories.CategoriaRepository;
import com.nelioalves.cursomc.repositories.CidadeRepository;
import com.nelioalves.cursomc.repositories.ClienteRepository;
import com.nelioalves.cursomc.repositories.EnderecoRepository;
import com.nelioalves.cursomc.repositories.EstadoRepository;
import com.nelioalves.cursomc.repositories.ProdutoRepository;

@Configuration
public class LocalData {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	@Autowired
	EstadoRepository estadoRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;

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
			
			categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
			produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
			
			Estado est1 = new Estado(null, "Minas Gerais");
			Estado est2 = new Estado(null, "São Pauulo");
			
			Cidade c1 = new Cidade(null, "Uberlândia", est1);
			Cidade c2 = new Cidade(null, "São Paulo", est2);
			Cidade c3 = new Cidade(null, "Campinas", est2);
			
			est1.getCidades().add(c1);
			est2.getCidades().add(c2);
			est2.getCidades().add(c3);
			
			estadoRepository.saveAll(Arrays.asList(est1, est2));
			cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
			
			Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA); 
			cli1.getTelefones().addAll(Arrays.asList("3411223344", "3499887744"));
			
			Endereco e1 = new Endereco(null, "Rua Flores", " 300", "Apto 303", "Jardim", "38060123", cli1, c1);
			Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38054000", cli1, c2);
			
			cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
			
			clienteRepository.save(cli1);
			enderecoRepository.saveAll(Arrays.asList(e1, e2));
		};
	}
	
}
