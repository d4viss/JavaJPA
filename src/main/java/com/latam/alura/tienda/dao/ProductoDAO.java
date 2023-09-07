package com.latam.alura.tienda.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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

	public List<Producto> consultarPorParametros(String nombre, BigDecimal precio, LocalDate fecha){
		StringBuilder jpql = new StringBuilder("SELECT p FROM Producto p WHERE 1=1 ");
		if(nombre != null && !nombre.trim().isEmpty()) {
			jpql.append(" AND p.nombre=:nombre");
		}
		if(precio != null && !precio.equals(new BigDecimal(0))) {
			jpql.append(" AND p.precio=:precio");
		}
		if(fecha != null) {
			jpql.append(" AND p.fechaRegistro=:fecha");
		}
		TypedQuery<Producto> query = manager.createQuery(jpql.toString(), Producto.class);
		if(nombre != null && !nombre.trim().isEmpty()) {
			query.setParameter("nombre", nombre);
		}
		if(precio != null && !precio.equals(new BigDecimal(0))) {
			query.setParameter("precio", precio);
		}
		if(fecha != null) {
			query.setParameter("fechaRegistro", fecha);
		}

		return query.getResultList();
	}

	public List<Producto> consultarPorParametrosConAPICriteria(String nombre, BigDecimal precio, LocalDate fecha){
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Producto> query = builder.createQuery(Producto.class);
		Root<Producto> from = query.from(Producto.class);

		Predicate filtro = builder.and();
		
		if(nombre != null && !nombre.trim().isEmpty()) {
			filtro =builder.and(filtro, builder.equal(from.get("nombre"), nombre));
		}
		if(precio != null && !precio.equals(new BigDecimal(0))) {
			filtro =builder.and(filtro, builder.equal(from.get("precio"), precio));

		}
		if(fecha != null) {
			filtro =builder.and(filtro, builder.equal(from.get("fechaRegistro"), fecha));

		}
		
		query = query.where(filtro);
		
		return manager.createQuery(query).getResultList();
	}
}
