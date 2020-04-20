package com.qintess.eventos.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;

@Entity
public class Evento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@EmbeddedId
	@ManyToOne(fetch = FetchType.LAZY
			   ,cascade = CascadeType.ALL)
	@MapsId("Evento")
	private CasaDeShow casaDeShow;
	
	@OneToMany(cascade = CascadeType.ALL
			,fetch = FetchType.LAZY
			,mappedBy = "evento"
			,orphanRemoval = true)
	List<CompraIngresso> listaIngressos = new ArrayList<>();
	
	private String nome;
	
	private String descrição;
	
	private String data;
		
	private int quantidadeIngressos;
	
	private double preço;
	
	private int quantidadeIngressosDisponiveis;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CasaDeShow getCasaDeShow() {
		return casaDeShow;
	}

	public void setCasaDeShow(CasaDeShow casaDeShow) {
		this.casaDeShow = casaDeShow;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrição() {
		return descrição;
	}

	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getQuantidadeIngressos() {
		return quantidadeIngressos;
	}

	public void setQuantidadeIngressos(int quantidadeIngressos) {
		this.quantidadeIngressos = quantidadeIngressos;
	}

	public double getPreço() {
		return preço;
	}

	public void setPreço(double preço) {
		this.preço = preço;
	}

	public int getQuantidadeIngressosDisponiveis() {
		return quantidadeIngressosDisponiveis;
	}

	public void setQuantidadeIngressosDisponiveis(int quantidadeIngressosDisponiveis) {
		this.quantidadeIngressosDisponiveis = quantidadeIngressosDisponiveis;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
