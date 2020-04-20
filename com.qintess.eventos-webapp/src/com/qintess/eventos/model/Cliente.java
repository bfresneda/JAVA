package com.qintess.eventos.model;

import java.io.Serializable;
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
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	
	private String email;
	
	private int cpf;
	
	@OneToMany(cascade = CascadeType.ALL
				,fetch = FetchType.LAZY
				,mappedBy = "cliente"
				,orphanRemoval = true)
	List<CompraIngresso> listaIngressos = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public List<CompraIngresso> getListaIngressos() {
		return listaIngressos;
	}

	public void setListaIngressos(List<CompraIngresso> listaIngressos) {
		this.listaIngressos = listaIngressos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
