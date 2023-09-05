package com.latam.alura.tienda.prueba;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.dao.CategoriaDAO;
import com.latam.alura.tienda.dao.ClienteDAO;
import com.latam.alura.tienda.dao.PedidoDAO;
import com.latam.alura.tienda.dao.ProductoDAO;
import com.latam.alura.tienda.modelo.Categoria;
import com.latam.alura.tienda.modelo.Cliente;
import com.latam.alura.tienda.modelo.ItemsPedido;
import com.latam.alura.tienda.modelo.Pedido;
import com.latam.alura.tienda.modelo.Producto;
import com.latam.alura.tienda.utils.JPAUtils;

public class RegistroDePedido {

	public static void main(String[] args) {
		registrarProducto();
		
		EntityManager manager = JPAUtils.getEntityManager();

		ProductoDAO productoDAO = new ProductoDAO(manager);
		
		Producto producto = productoDAO.consultaPorId(1l);
	
		ClienteDAO clienteDAO = new ClienteDAO(manager);
		PedidoDAO pedidoDAO = new PedidoDAO(manager);
		
		Cliente cliente = new Cliente("juan", "elenemigos");
		Pedido pedido = new Pedido(cliente);
		pedido.agregarItems(new ItemsPedido(5, producto, pedido));
		
		manager.getTransaction().begin();

		clienteDAO.guardar(cliente);
		pedidoDAO.guardar(pedido);
		
		manager.getTransaction().commit();

	}

	private static void registrarProducto() {
		Categoria celulares = new Categoria("CELULARES");
		
		Producto celular = new Producto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares);
		
		EntityManager manager = JPAUtils.getEntityManager();
		ProductoDAO productoDAO = new ProductoDAO(manager);
		CategoriaDAO categoriaDAO = new CategoriaDAO(manager);
		
		manager.getTransaction().begin();
		
		categoriaDAO.guardar(celulares);
		productoDAO.guardar(celular);
		
		manager.getTransaction().commit();
		manager.close();
	}

}
