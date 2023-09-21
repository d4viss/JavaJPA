package com.latam.alura.tienda.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.modelo.Cliente;


public class ClienteDAO {

	private EntityManager manager;
	
	public ClienteDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	public void guardar(Cliente Cliente) {
		this.manager.persist(Cliente);
	}
	
	public Cliente consultaPorId(Long id) {
		return manager.find(Cliente.class, id);
	}
	
	public List<Cliente> consultarTodos(){
		String jpql = "SELECT P FROM Cliente AS P";
		return manager.createQuery(jpql, Cliente.class).getResultList();
	}
	
	public List<Cliente> consultaPorNombre(String nombre){
		String jpql = "SELECT P FROM Cliente AS P WHERE P.nombre = :nombre";
//		String jpql = "SELECT P FROM Cliente AS P WHERE P.nombre = 1";
		return manager.createQuery(jpql, Cliente.class).setParameter("nombre", nombre).getResultList();
	}
	
	public List<Cliente> consultaPorCategoria(String categoria){
		String jpql = "SELECT P FROM Cliente AS P WHERE P.categoria.nombre = :categoria";
		return manager.createQuery(jpql, Cliente.class).setParameter("categoria", categoria).getResultList();
	}
	
	public BigDecimal consultaPrecioPorNombreCliente(String nombre) {
		String jpql = "SELECT P.precio FROM Cliente AS P WHERE P.nombre = :nombre";
		return manager.createQuery(jpql, BigDecimal.class).setParameter("nombre", nombre).getSingleResult();
	}
}
