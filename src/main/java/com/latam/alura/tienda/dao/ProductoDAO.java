package com.latam.alura.tienda.dao;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.modelo.Producto;

public class ProductoDAO {

	private EntityManager manager;
	
	public ProductoDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	public void guardar(Producto producto) {
		this.manager.persist(producto);
	}
}
