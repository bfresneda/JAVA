package com.qintess.eventos.model;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class CompraIngresso {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@EmbeddedId
	@ManyToOne(fetch = FetchType.LAZY
				,cascade = CascadeType.ALL)
	@MapsId("ClienteId")
	private Cliente cliente;
	
	
	@EmbeddedId
	@ManyToOne(fetch = FetchType.LAZY
				,cascade = CascadeType.ALL)
	@MapsId("EventosId")
	private Evento evento;
	
	
	private double preco;
	
	private int quantidade;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
}
