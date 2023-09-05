package com.latam.alura.tienda.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.modelo.Pedido;


public class PedidoDAO {

	private EntityManager manager;
	
	public PedidoDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	public void guardar(Pedido pedido) {
		this.manager.persist(pedido);
	}
	
	public Pedido consultaPorId(Long id) {
		return manager.find(Pedido.class, id);
	}
	
	public List<Pedido> consultarTodos(){
		String jpql = "SELECT P FROM pedido AS P";
		return manager.createQuery(jpql, Pedido.class).getResultList();
	}
	
	public List<Pedido> consultaPorNombre(String nombre){
		String jpql = "SELECT P FROM pedido AS P WHERE P.nombre = :nombre";
//		String jpql = "SELECT P FROM pedido AS P WHERE P.nombre = 1";
		return manager.createQuery(jpql, Pedido.class).setParameter("nombre", nombre).getResultList();
	}
	
	public List<Pedido> consultaPorCategoria(String categoria){
		String jpql = "SELECT P FROM pedido AS P WHERE P.categoria.nombre = :categoria";
		return manager.createQuery(jpql, Pedido.class).setParameter("categoria", categoria).getResultList();
	}
	
	public BigDecimal consultaPrecioPorNombrepedido(String nombre) {
		String jpql = "SELECT P.precio FROM pedido AS P WHERE P.nombre = :nombre";
		return manager.createQuery(jpql, BigDecimal.class).setParameter("nombre", nombre).getSingleResult();
	}
}
