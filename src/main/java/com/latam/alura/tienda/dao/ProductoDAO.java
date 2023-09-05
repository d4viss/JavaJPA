package com.latam.alura.tienda.dao;

import java.math.BigDecimal;
import java.util.List;

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
	
	public Producto consultaPorId(Long id) {
		return manager.find(Producto.class, id);
	}
	
	public List<Producto> consultarTodos(){
		String jpql = "SELECT P FROM Producto AS P";
		return manager.createQuery(jpql, Producto.class).getResultList();
	}
	
	public List<Producto> consultaPorNombre(String nombre){
		String jpql = "SELECT P FROM Producto AS P WHERE P.nombre = :nombre";
//		String jpql = "SELECT P FROM Producto AS P WHERE P.nombre = 1";
		return manager.createQuery(jpql, Producto.class).setParameter("nombre", nombre).getResultList();
	}
	
	public List<Producto> consultaPorCategoria(String categoria){
		String jpql = "SELECT P FROM Producto AS P WHERE P.categoria.nombre = :categoria";
		return manager.createQuery(jpql, Producto.class).setParameter("categoria", categoria).getResultList();
	}
	
	public BigDecimal consultaPrecioPorNombreProducto(String nombre) {
		return manager.createNamedQuery("Producto.consultaDePrecio", BigDecimal.class).setParameter("nombre", nombre).getSingleResult();
	}
}
