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
	
	public void actualizar(Categoria categoria) {
		this.manager.merge(categoria);
	}
	
	private void remover(Categoria categoria) {
		categoria = this.manager.merge(categoria);
		this.manager.remove(categoria);
	}
}
