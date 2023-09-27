package com.latam.alura.tienda.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.modelo.Pedido;
import com.latam.alura.tienda.vo.RelatorioVenta;


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
	
	public BigDecimal valorTotalVendido() {
		String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p";
		return manager.createQuery(jpql, BigDecimal.class).getSingleResult();
	}
	
	public BigDecimal valorPromedioVendido() {
		String jpql = "SELECT AVG(p.valorTotal) FROM Pedido p";
		return manager.createQuery(jpql, BigDecimal.class).getSingleResult();
	}
	
	public List<Object[]> relatorioDeVentas(){
		String jpql = "SELECT producto.nombre, "
				+ "SUM(item.cantidad), "
				+ "MAX(pedido.fecha) "
				+ "FROM Pedido pedido "
				+ "JOIN pedido.items item "
				+ "JOIN item.producto producto "
				+ "GROUP BY producto.nombre "
				+ "ORDER BY item.cantidad DESC";
		return manager.createQuery(jpql, Object[].class).getResultList();
	}
	
	public List<RelatorioVenta> relatorioDeVentasVO(){
		String jpql = "SELECT new com.latam.alura.tienda.vo.RelatorioVenta(producto.nombre, "
				+ "SUM(item.cantidad), "
				+ "MAX(pedido.fecha)) "
				+ "FROM Pedido pedido "
				+ "JOIN pedido.items item "
				+ "JOIN item.producto producto "
				+ "GROUP BY producto.nombre "
				+ "ORDER BY item.cantidad DESC";
		return manager.createQuery(jpql, RelatorioVenta.class).getResultList();
	}
	
	public Pedido consultarPedidoConCliente(Long id) {
		String jpql = "SELECT p FROM Pedido p JOIN FETCH p.cliente WHERE p.id=:id";
		return manager.createQuery(jpql, Pedido.class).setParameter("id", id).getSingleResult();
	}
}
