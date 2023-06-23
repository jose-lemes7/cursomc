package com.nelioalves.cursomc.entities;

import com.nelioalves.cursomc.entities.enums.EstadoPagamento;

public class Pagamento {

	private Long id;
	private EstadoPagamento estado;
	
	private Pedido pedido;
}
