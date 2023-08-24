package com.latam.alura.tienda.dao;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.modelo.Categoria;

public class CategoriaDAO {

	private EntityManager manager;
	
	public CategoriaDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	public void guardar(Categoria categoria) {
		this.manager.persist(categoria);
	}
}
