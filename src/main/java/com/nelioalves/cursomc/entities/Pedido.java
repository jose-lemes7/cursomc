package com.nelioalves.cursomc.entities;

import java.util.Date;

public class Pedido {

	private Long id;
	private Date instante;
	
	private Pagamento pagamento;
	
	private Cliente cliente;
	
	private Endereco enderecoDeEntrega;
}
