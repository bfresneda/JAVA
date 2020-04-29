package com.qintess.eventos.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Evento{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
//	@ManyToOne(fetch = FetchType.LAZY
//			   ,cascade = CascadeType.ALL)
//	@MapsId("Evento")
//	private CasaDeShow casaDeShow;
	
	@OneToMany(cascade = CascadeType.ALL
			,fetch = FetchType.LAZY
			,mappedBy = "evento"
			,orphanRemoval = true)
	List<CompraIngresso> listaIngressos = new ArrayList<>();
	
	private String nome;
	
	private String descricao;
	
	private String data;
		
	private int quantidadeIngressos;

//	private Long idCasaDeShowEvento;
	
	private double preco;
	
	private int quantidadeIngressosDisponiveis;
	
//	@Column(columnDefinition="bytea")
//	private byte[] imagemEvento;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public CasaDeShow getCasaDeShow() {
//		return casaDeShow;
//	}
//
//	public void setCasaDeShow(CasaDeShow casaDeShow) {
//		this.casaDeShow = casaDeShow;
//	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidadeIngressosDisponiveis() {
		return quantidadeIngressosDisponiveis;
	}

	public void setQuantidadeIngressosDisponiveis(int quantidadeIngressosDisponiveis) {
		this.quantidadeIngressosDisponiveis = quantidadeIngressosDisponiveis;
	}

//	public Long getIdCasaDeShowEvento() {
//		return idCasaDeShowEvento;
//	}
//
//	public void setIdCasaDeShowEvento(Long idCasaDeShowEvento) {
//		this.idCasaDeShowEvento = idCasaDeShowEvento;
//	}

	public List<CompraIngresso> getListaIngressos() {
		return listaIngressos;
	}

	public void setListaIngressos(List<CompraIngresso> listaIngressos) {
		this.listaIngressos = listaIngressos;
	}

//	public byte[] getImagemEvento() {
//		return imagemEvento;
//	}
//
//	public void setImagemEvento(byte[] imagemEvento) {
//		this.imagemEvento = imagemEvento;
//	}
	
	
	
}
