package com.latam.alura.tienda.modelo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "electronicos")
public class Electronicos extends Producto{

	private String marca, modelo;

	public Electronicos() {
	}
	
	public Electronicos(String marca, String modelo) {
		super();
		this.marca = marca;
		this.modelo = modelo;
	}
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	
}
