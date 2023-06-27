package com.nelioalves.cursomc.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Double preco;

	@JsonIgnoreProperties("produtos")
	@ManyToMany
	@JoinTable(name="PRODUTO_CATEGORIA")
	private List<Categoria> categorias = new ArrayList<>();
	
	@OneToMany(mappedBy = "id.produto")
	private Set<ItemPedido> itens = new HashSet<>();

	public Set<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}

	public Produto() {
		super();
	}

	public Produto(String nome, Double preco) {
		super();
		this.nome = nome;
		this.preco = preco;
	}
	
	public List<Pedido> getPedidos() {
		return itens.stream().map(i -> i.getPedido()).toList();
	}

	public void addCategorias(Categoria... categorias) {
		for (Categoria categoria : categorias) {
			this.categorias.add(categoria);
			categoria.getProdutos().add(this);
		}
	}
	
	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}



}
